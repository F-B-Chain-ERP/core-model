# Kế hoạch: Scaffold `erp-core-model` (base + 8 bảng auth)

## Context
- `core-model` trong workspace hiện TRỐNG (chỉ `.gitignore` + `README.md` rỗng). Cần dựng từ đầu theo pattern JHipster-style từ guide, KHÔNG copy entity kế toán.
- `backend-service` đã có: **Spring Boot 4.1.0 + Java 21**, `spring-boot-starter-webmvc`, `data-jpa`, `validation`, `security`, `postgresql` (runtime). Core module phải khớp version này.
- Mục tiêu lượt này: dựng **base infrastructure** + **8 bảng auth** bro đã đưa, để bro "xem qua" rồi mở rộng ~22 bảng nghiệp vụ sau.
- Quyết định đã chốt:
  - **Multi-tenancy = CÓ**, nhưng thực hiện **row-level** (base entity có trường tenant) để sau này không đập đi xây lại. Auth 8 bảng là reference data cross-tenant → **không** mang cột tenant (khớp DBML).
  - PK = **UUID `char(36)`** (theo schema).
  - Lỗi: dùng **Spring native `ProblemDetail` (RFC 7807)** thay Zalando (SB4 đã có sẵn, tránh dependency jakarta lỗi).
  - Library jar: **không** `@SpringBootApplication` main, không `repackage`; dùng `@AutoConfiguration` + file imports.

## Package structure (base = `com.erp.core`)
```
com.erp.core
├── common/
│   ├── entity/
│   │   ├── BaseEntity.java          // id(UUID) + createdAt/updatedAt + createdBy/updatedBy + status
│   │   └── BaseTenantEntity.java    // extends BaseEntity + tenantId (cho bảng nghiệp vụ sau)
│   ├── exception/
│   │   ├── ApiException.java        // base RuntimeException (HttpStatusCode + code)
│   │   ├── BadRequestAlertException.java
│   │   ├── ResourceNotFoundException.java
│   │   └── GlobalExceptionHandler.java  // @RestControllerAdvice -> ProblemDetail
│   ├── util/
│   │   ├── PaginationUtil.java
│   │   └── HeaderUtil.java
│   └── config/
│       └── CoreAutoConfiguration.java   // @AutoConfiguration + @EnableJpaAuditing
├── domain/        // 8 entity auth: IaAccount, IaRole, IaPermission, IaRolePermission, IaScope, IaAccountRoleAssignment, IaAuditLog, IaRefreshToken
├── repository/    // Spring Data repo cho 8 entity
├── dto/           // Response/Export DTO (lượt này tối thiểu: AccountResponse, RoleResponse...)
├── enums/         // AuthProvider, EntityStatus, RoleType, ScopeType
└── constants/     // tên bảng, default value, message key
```
Ghi chú: cấu trúc `domain/dto/enums/constants/common` bro đề xuất là OK; tôi thêm `repository/` và gom lỗi/audit/util vào `common/`.

## Base entities
- `BaseEntity` (`@MappedSuperclass` + `@EntityListeners(AuditingEntityListener.class)`):
  - `id`: `@Id String`, sinh UUID trong `@PrePersist` (nếu null). `@Column(columnDefinition="char(36)", length=36)`.
  - `createdAt`/`updatedAt`: `Instant`, `@CreatedDate`/`@LastModifiedDate` (tự động qua AuditingEntityListener).
  - `createdBy`/`updatedBy`: `String` (UUID), **plain column** (nullable), app tự set (chưa dùng `@CreatedBy` vì chưa có `AuditorAware`; thêm sau nếu cần).
  - `status`: `String` (default `"ACTIVE"`), map `EntityStatus` enum.
- `BaseTenantEntity extends BaseEntity`: thêm `tenantId` `@Column(columnDefinition="char(36)")` — dành ~22 bảng nghiệp vụ.

## 8 entity auth (extends `BaseEntity`, không tenant)
Map 1-1 từ DBML. Lưu ý:
- Enum: `authProvider`→`AuthProvider`(LOCAL,...), `status`→`EntityStatus`(ACTIVE,INACTIVE), `roleType`→`RoleType`(SYSTEM,...), `scopeType`→`ScopeType`(định nghĩa sau), assigment/role_permission/refresh token `status`→`EntityStatus`.
- FK dùng `@ManyToOne` + `@JoinColumn` (vd `IaRolePermission.role` → `IaRole`). Unique composite dùng `@Table(uniqueConstraints=...)`.
- `before_data`/`after_data` (json): `@Column(columnDefinition="json") @JdbcTypeCode(SqlTypes.JSON)` → `Map<String,Object>`.
- `hasLocalPassword` boolean default true; `lastLoginAt`, `expiresAt`, `revokedAt` nullable.
- Tên bảng: `@Table(name="ia_account")` (viết thường, giữ prefix `ia_`).

## Repository (`com.erp.core.repository`)
Interface `@Repository` extends `JpaRepository<...,String>`:
- `IaAccountRepository`: `findByUsername`, `findByEmail`, `findByUsernameOrEmail`.
- `IaRoleRepository`: `findByCode`.
- `IaPermissionRepository`, `IaRolePermissionRepository` (find by roleId), `IaScopeRepository` (find by scopeType+branchId), `IaAccountRoleAssignmentRepository` (find by accountId), `IaAuditLogRepository`, `IaRefreshTokenRepository` (`findByTokenHash`).

## common/exception (RFC 7807 native)
- `ApiException extends RuntimeException` mang `HttpStatusCode` + error `code`.
- `BadRequestAlertException`, `ResourceNotFoundException` extends `ApiException`.
- `GlobalExceptionHandler` `@RestControllerAdvice`: bắt `ApiException` và `MethodArgumentNotValidException` → trả `ProblemDetail` (title/message/detail/properties=fieldErrors). Bean này nằm trong `CoreAutoConfiguration` (consumer auto-pickup).

## common/util
- `PaginationUtil`: build `Page` headers (`X-Total-Count`, `Link`) từ `Page` Spring Data.
- `HeaderUtil`: `createAlert`/`createEntityCreationAlert` trả `HttpHeaders`.

## pom.xml (`erp-core-model`)
- parent: `spring-boot-starter-parent:4.1.0`; `groupId=com.erp`, `artifactId=erp-core-model`, `packaging=jar`, `java.version=21`.
- deps: `spring-boot-starter-data-jpa`, `spring-boot-starter-validation`, `org.springframework:spring-web` (scope `provided` — backend-service đã có webmvc, tránh bundle), `spring-boot-starter-security` (provided, nếu cần sau).
- **KHÔNG** thêm `spring-boot-maven-plugin` repackage (giữ jar thư viện bình thường).
- **KHÔNG** datasource / postgres driver (consumer cung cấp).
- jakarta namespace (`jakarta.persistence.*`).

## Auto-config registration
- `src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`:
  `com.erp.core.common.config.CoreAutoConfiguration`
- `CoreAutoConfiguration`: `@AutoConfiguration`, `@EnableJpaAuditing`, `@ComponentScan("com.erp.core.common")`.

## Validation (khi implement xong)
1. `mvn clean install` trong `core-model` → jar build thành công, không lỗi compile (jakarta đúng).
2. `backend-service` thêm dependency `com.erp:erp-core-model`, cấu hình:
   `@EntityScan("com.erp.core.domain")`, `@EnableJpaRepositories("com.erp.core.repository")` (hoặc để auto-config quét). Chạy app, `spring.jpa.hibernate.ddl-auto=update` → tạo đúng 8 bảng `ia_*`, có cột `created_at/updated_at/created_by/updated_by/status`.
3. Insert 1 `IaAccount` (qua repo/test) → `created_at/updated_at` tự điền (chứng tỏ `@EnableJpaAuditing` hoạt động).
4. Gọi API sai validate (hoặc ném `BadRequestAlertException`) → nhận JSON `ProblemDetail` chuẩn (status/title/detail).
5. Phân trang repo → header `X-Total-Count`/`Link` từ `PaginationUtil`.

## Rủi ro / lưu ý
- `spring-boot-maven-plugin` repackage sẽ biến jar thành executable → consumer không link được. Phải bỏ/disable.
- Nếu consumer gộp nhiều module bean trùng → set `spring.main.allow-bean-definition-overriding=true`.
- `createdBy/updatedBy` chưa auto (không AuditorAware). Nếu muốn tự động, thêm `AuditorAware<String>` bean + `@CreatedBy/@LastModifiedBy` sau.
- `@EnableJpaAuditing` bắt buộc (thiếu → created_at null). Đã nằm trong auto-config.
- JSON column cần Postgres; dialect do consumer chỉ định.

## Open / next steps
- Định nghĩa chính xác value `ScopeType`, `RoleType` (bro confirm).
- DTO + VM login (username/password) và mapper entity↔DTO.
- ~22 bảng nghiệp vụ sau này extends `BaseTenantEntity`.
- `AuditorAware` nếu cần auto created_by/updated_by.

