# Hướng dẫn sử dụng `erp-core-model`

Module `core-model` là **thư viện chia sẻ** (library jar) chứa:
- Base infrastructure (entity cha, exception RFC 7807, util phân trang).
- 8 bảng auth (`ia_*`) dùng chung cho toàn bộ hệ thống ERP.

Module này là **library jar** để service khác import. Hiện vẫn có `CoreApplication`
phục vụ test/context bootstrap, nhưng không cấu hình `spring-boot-maven-plugin`
repackage nên artifact build ra vẫn là jar thư viện.

---

## 1. Yêu cầu

| Thành phần | Phiên bản |
|------------|-----------|
| Java       | 21        |
| Spring Boot| 4.1.0     |
| Maven      | 3.6+      |

> Lưu ý: `pom.xml` đang khai báo `<java.version>21</java.version>`. Nếu Maven đang chạy JDK 17 sẽ fail compile với lỗi `release version 21 not supported`.
> Trỏ `JAVA_HOME` vào JDK 21 trước khi build:
> ```powershell
> $env:JAVA_HOME="C:\Program Files\Java\jdk-21"
> $env:Path="$env:JAVA_HOME\bin;$env:Path"
> java -version
> mvn -version
> ```

---

## 2. Build & cài vào local repository

```powershell
cd core-model
mvn -q dependency:resolve
mvn -q clean install
```

Kết quả: `target/erp-core-model-0.0.1-SNAPSHOT.jar` và được cài vào `~/.m2/repository/com/erp/erp-core-model/`.

Không dùng `spring-boot-maven-plugin` repackage (giữ nguyên jar thư viện để consumer link được).

---

## 3. Tích hợp vào `backend-service` (consumer)

### 3.1. Thêm dependency (`backend-service/pom.xml`)
```xml
<dependency>
    <groupId>com.erp</groupId>
    <artifactId>erp-core-model</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
Không cần khai báo version nếu `backend-service` cũng dùng `spring-boot-starter-parent:4.1.0`.

### 3.2. Quét entity
Trong `BackendServiceApplication.java`:
```java
@SpringBootApplication
@EntityScan("com.erp.core.domain")
public class BackendServiceApplication { ... }
```

Repository nằm ở service consumer. Core hiện chỉ cung cấp entity/model, DTO, exception,
VM và util dùng chung.

`CoreApplication` bật `@EnableJpaAuditing` và component scan mặc định trong package
`com.erp.core`, nên khi consumer scan/import package core thì exception handler, util và
VM dùng được cùng application context.

### 3.3. Cấu hình datasource & JPA (`application.yaml`)
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/erp
    username: <db_user>
    password: <db_pass>
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
  main:
    allow-bean-definition-overriding: true   # nếu bean trùng giữa các module
```
Postgres driver đã có sẵn trong `backend-service` (scope runtime). Core **không** mang driver/datasource.

---

## 4. Kiểm thử nhanh

1. Chạy app với `ddl-auto: update` → Hibernate tạo 8 bảng `ia_*`, mỗi bảng có sẵn
   cột `created_at`, `updated_at`, `created_by`, `updated_by`, `status`.
2. Insert 1 `IaAccount` qua repository của consumer → `created_at`/`updated_at` tự động điền
   (chứng tỏ `@EnableJpaAuditing` hoạt động).
3. Ném `BadRequestAlertException` trong controller → nhận JSON `ProblemDetail`
   chuẩn (RFC 7807): `status`, `title`, `detail`, `properties.code`.
4. Gọi repo phân trang → response có header `X-Total-Count` và `Link`.

---

## 5. Lưu ý quan trọng

- **`createdBy`/`updatedBy` chưa tự động**: chưa có `AuditorAware`, app tự set thủ công.
- **Enum chưa chốt giá trị**: `ScopeType`, `RoleType` đang để giá trị dự kiến — confirm
  với nghiệp vụ trước khi dùng chính thức.
- **JSON column** (`before_data`/`after_data` của `ia_audit_log`) dùng Postgres
  (`@JdbcTypeCode(SqlTypes.JSON)`), cần dialect Postgres.
- **Auth tables không có cột tenant** (là reference data cross-tenant). Các bảng
  nghiệp vụ sau này extends `BaseTenantEntity` (có `tenantId`) thay vì `BaseAuditingEntity`.
- **Không có repository trong core** ở trạng thái hiện tại. Consumer tự định nghĩa repository
  nếu cần thao tác DB.

Xem chi tiết cấu trúc & công năng từng lớp tại [STRUCTURE.md](./STRUCTURE.md).
