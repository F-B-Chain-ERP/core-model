# Cấu trúc & công năng `erp-core-model`

Package gốc: `com.erp.core`. Cây thư mục nguồn:

```
com.erp.core
├── CoreApplication.java
├── domain/            # BaseAuditingEntity, BaseTenantEntity, 8 entity auth (ia_*)
├── web/rest/errors/   # ApiException, BadRequestAlertException,
│                      # ResourceNotFoundException, GlobalExceptionHandler
├── web/rest/util/     # PaginationUtil, HeaderUtil
├── web/rest/vm/       # LoginVM
├── dto/               # AccountResponse, RoleResponse
├── enums/             # EntityStatus, AuthProvider, RoleType, ScopeType
└── constants/         # TableName, Defaults, MessageKey
```

---

## 1. `domain` — nền tảng entity

### `BaseAuditingEntity` (MappedSuperclass)
Lớp cha chung cho mọi entity. Cung cấp:
- `id` — `@Id String`, UUID, sinh tự động trong `@PrePersist` nếu null,
  map `char(36)`.
- `createdAt` / `updatedAt` — `Instant`, tự động qua `AuditingEntityListener`
  (`@CreatedDate` / `@LastModifiedDate`).
- `createdBy` / `updatedBy` — `String` (UUID), **plain column**, app tự set
  (chưa có `AuditorAware`).
- `status` — `String` (default `"ACTIVE"`), lifecycle chung.

### `BaseTenantEntity extends BaseAuditingEntity`
Thêm `tenantId` (`char(36)`, not null) → multi-tenancy row-level.
Dành cho ~22 bảng nghiệp vụ sau này. Auth 8 bảng **không** extends lớp này
(vì là reference data cross-tenant, không mang cột tenant).

---

## 2. `domain` — 8 entity auth

Tất cả extends `BaseAuditingEntity`, tên bảng giữ prefix `ia_`.

| Entity | Bảng | Điểm chú ý |
|--------|------|-----------|
| `IaAccount` | `ia_account` | `username`, `email` unique; `authProvider` (enum), `hasLocalPassword` (bool), `lastLoginAt`. |
| `IaRole` | `ia_role` | `code` unique; `roleType` (enum). |
| `IaPermission` | `ia_permission` | `code` unique; `resource`, `action`. |
| `IaRolePermission` | `ia_role_permission` | `@ManyToOne` → `IaRole`, `IaPermission`. Unique `(role_id, permission_id)`. |
| `IaScope` | `ia_scope` | `scopeType` (enum), `branchId`. Unique `(scope_type, branch_id)`. |
| `IaAccountRoleAssignment` | `ia_account_role_assignment` | `@ManyToOne` → `IaAccount`, `IaRole`, `IaScope` (nullable). Unique `(account_id, role_id, scope_id)`. |
| `IaAuditLog` | `ia_audit_log` | `before_data`/`after_data` JSON map (`@JdbcTypeCode(SqlTypes.JSON)`), `occurredAt`. |
| `IaRefreshToken` | `ia_refresh_token` | `tokenHash` unique; `@ManyToOne` → `IaAccount`; `expiresAt`, `revokedAt`. |

FK được map bằng `@ManyToOne` + `@JoinColumn` (không dùng raw column) để tận dụng JPA.
`status` của các entity auth kế thừa từ `BaseAuditingEntity` (kiểu `String`).

---

## 3. Repository

Core hiện **không định nghĩa Spring Data repository**. Consumer service tự tạo
repository theo nhu cầu, ví dụ:

```java
public interface IaAccountRepository extends JpaRepository<IaAccount, String> {
    Optional<IaAccount> findByUsername(String username);
    Optional<IaAccount> findByEmail(String email);
}
```

---

## 4. `web/rest/errors` — xử lý lỗi RFC 7807

- `ApiException extends RuntimeException` — mang `HttpStatusCode` + `code`.
- `BadRequestAlertException` / `ResourceNotFoundException` — subclass cụ thể.
- `GlobalExceptionHandler` (`@RestControllerAdvice`) — bắt `ApiException` và
  `MethodArgumentNotValidException` → trả `ProblemDetail` (status/title/detail/properties).
  Được quét khi consumer scan/import package `com.erp.core`.

---

## 5. `web/rest/util`

- `PaginationUtil` — sinh header `X-Total-Count` + `Link` từ `Page` Spring Data.
- `HeaderUtil` — `createAlert` / `createEntityCreationAlert` / `update` / `deletion`
  trả `HttpHeaders` (alert entity CRUD).

---

## 6. `web/rest/vm`

- `LoginVM` — request body đăng nhập cơ bản.

---

## 7. `CoreApplication`

- `CoreApplication` — `@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)`
  + `@EnableJpaAuditing`.
- Loại trừ datasource auto-config để module không tự yêu cầu DB khi chỉ build/test library.
- Không có `spring-boot-maven-plugin` repackage, artifact vẫn là library jar.

---

## 8. `dto` — đối tượng truyền tải

- `AccountResponse`, `RoleResponse` — projection read-side (tối thiểu lượt này).
- `status` trong DTO dùng enum `EntityStatus` (convert từ `String` của entity khi map).

---

## 9. `enums` & `constants`

- `enums`: `EntityStatus` (ACTIVE/INACTIVE/DELETED/LOCKED), `AuthProvider`
  (LOCAL/GOOGLE/...), `RoleType` (SYSTEM/TENANT/LOCAL), `ScopeType`
  (GLOBAL/BRANCH/DEPARTMENT/WAREHOUSE/STORE) — *giá trị chưa chốt chính thức*.
- `constants`: `TableName` (tên bảng `ia_*`), `Defaults` (status/authProvider/
  hasLocalPassword mặc định), `MessageKey` (key i18n).

---

## 10. Cơ chế tích hợp

Khi `backend-service` thêm dependency `erp-core-model`:
1. Consumer thêm `@EntityScan("com.erp.core.domain")` để Hibernate nhận entity core.
2. Consumer định nghĩa repository trong service của mình nếu cần truy cập DB.
3. Consumer scan/import `com.erp.core` để dùng `GlobalExceptionHandler`, util, VM.
4. `@EnableJpaAuditing` cần được bật trong application context consumer để `created_at`/`updated_at` tự động.
