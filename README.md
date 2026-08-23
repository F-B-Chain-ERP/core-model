# 📦 ERP Core Model (`erp-core-model`)
> **Thư viện Domain Model, Base Entities, DTOs & Tiện ích chung cho Hệ sinh thái ERP Pine Drink (ERP-UTT)**

---

## 🧭 MỤC LỤC
1. [Project Overview (Tổng quan dự án)](#1-project-overview-tổng-quan-dự-án)
2. [Problem & Solution (Vấn đề & Giải pháp)](#2-problem--solution-vấn-đề--giải-pháp)
3. [Core Features (Tính năng cốt lõi)](#3-core-features-tính-năng-cốt-lõi)
4. [Business Flow (Luồng xử lý nghiệp vụ)](#4-business-flow-luồng-xử-lý-nghiệp-vụ)
5. [System Architecture (Kiến trúc hệ thống)](#5-system-architecture-kiến-trúc-hệ-thống)
6. [Tech Stack (Công nghệ sử dụng)](#6-tech-stack-công-nghệ-sử-dụng)
7. [Repository Structure (Cấu trúc thư mục)](#7-repository-structure-cấu-trúc-thư-mục)
8. [Getting Started (Bắt đầu nhanh)](#8-getting-started-bắt-đầu-nhanh)
9. [Configuration (Cấu hình)](#9-configuration-cấu-hình)
10. [API Documentation (Quy chuẩn API & DTOs)](#10-api-documentation-quy-chuẩn-api--dtos)
11. [Security (Bảo mật & Kiểm toán)](#11-security-bảo-mật--kiểm-toán)
12. [Database (Cơ sở dữ liệu & Entity Mapping)](#12-database-cơ-sở-dữ-liệu--entity-mapping)
13. [Testing (Kiểm thử)](#13-testing-kiểm-thử)
14. [CI/CD (Tích hợp & Phân phối liên tục)](#14-cicd-tích-hợp--phân-phối-liên-tục)
15. [Deployment (Triển khai & Đóng gói)](#15-deployment-triển-khai--đóng-gói)
16. [Monitoring (Giám sát & Nhật ký)](#16-monitoring-giám-sát--nhật-ký)
17. [Development / Contribution (Quy chuẩn phát triển & Đóng góp)](#17-development--contribution-quy-chuẩn-phát-triển--đóng-góp)
18. [Documentation (Tài liệu tham chiếu)](#18-documentation-tài-liệu-tham-chiếu)

---

## 1. Project Overview (Tổng quan dự án)

`erp-core-model` là **thư viện nền tảng (Shared Java Library JAR)** đóng vai trò hạt nhân chuẩn hóa toàn bộ cấu trúc dữ liệu cho hệ sinh thái ERP Chuỗi F&B Pine Drink (ERP-UTT).

Dự án là "Single Source of Truth" (Nguồn chân lý duy nhất) định nghĩa:
* **Hạ tầng Entity cơ sở:** Các lớp cha `BaseAuditingEntity` và `BaseTenantEntity` cung cấp tự động hóa kiểm toán dữ liệu và hỗ trợ Multi-tenancy.
* **Domain Model chuẩn hóa:** Ánh xạ 1:1 chính xác với lược đồ CSDL chuẩn `erp_schema.sql`.
* **Data Transfer Objects (DTOs):** Các cấu trúc Request DTOs (gắn sẵn Jakarta Bean Validation) và Response DTOs phân tách theo ngữ cảnh hiển thị.
* **Chuẩn hóa Xử lý Lỗi REST API:** Triển khai theo tiêu chuẩn quốc tế **RFC 7807 (Problem Details for HTTP APIs)**.
* **Tiện ích chung:** Phân trang Header (`PaginationUtil`), cảnh báo HTTP (`HeaderUtil`), Constants và Enums toàn hệ thống.

---

## 2. Problem & Solution (Vấn đề & Giải pháp)

### 2.1. Vấn đề thực tế (Problem)
* **Phân mảnh mô hình dữ liệu:** Khi phát triển nhiều module/microservice, việc tự định nghĩa Entity và DTO ở từng nơi dễ dẫn đến lệch kiểu dữ liệu, thiếu kiểm soát validate và sai lệch quy tắc nghiệp vụ.
* **Cạm bẫy JPA kinh điển:** Việc lạm dụng các quan hệ đối tượng lồng nhau (`@OneToMany`, `@ManyToOne`, `@ManyToMany`, `@JoinColumn`) dẫn tới các lỗi nghiêm trọng: **N+1 Query**, xóa nhầm dữ liệu dây chuyền ngoài ý muốn (**Cascade Delete**), vòng lặp vô tận khi chuyển đổi JSON (**Circular JSON Serialization**) và phụ thuộc vòng giữa các domain.
* **Không đồng nhất định dạng lỗi:** Mỗi service trả về một cấu trúc lỗi khác nhau gây khó khăn cho Frontend trong việc hiển thị thông báo lỗi.

### 2.2. Giải pháp của Core-Model (Solution)
* **Đóng gói tập trung thành Library JAR:** Toàn bộ Entity, DTO, Enums, Error Handlers được quản lý tại một repository duy nhất.
* **Kiến trúc Flat ID Mapping (Đặc thù tối ưu):** Entity **chỉ lưu ID đơn thuần dạng `UUID`** (ví dụ: `supplierId`, `warehouseId`, `accountId`). Việc ghép nối dữ liệu do tầng Service/Repository của consumer đảm nhận.
* **Đồng nhất chuẩn phản hồi lỗi RFC 7807:** Mọi ngoại lệ (`ApiException`, `BadRequestAlertException`, `ResourceNotFoundException`) đều trả về cấu trúc chuẩn `ProblemDetail` (status, title, detail, properties).

---

## 3. Core Features (Tính năng cốt lõi)

| Tính năng | Thành phần phụ trách | Mô tả chi tiết |
| :--- | :--- | :--- |
| **Base Auditing** | `BaseAuditingEntity` | Tự động sinh `id` (UUID char 36), điền `createdAt`, `updatedAt` qua `@CreatedDate`/`@LastModifiedDate`, quản lý `createdBy`, `updatedBy`, `status`. |
| **Multi-Tenancy** | `BaseTenantEntity` | Kế thừa `BaseAuditingEntity` + bổ sung `tenantId` cho các bảng nghiệp vụ đa chi nhánh/tenant. |
| **Auth & SYS Domain** | `Account`, `Role`, `Permission`, `Scope`,... | 8 Entity phục vụ xác thực, phân quyền RBAC và quản lý tài khoản nội bộ. |
| **Jakarta Validation** | `com.erp.core.dto.request.*` | Request DTOs gắn sẵn `@NotBlank`, `@Size`, `@NotNull`, `@Min`, `@Email` ngăn chặn dữ liệu rác ngay từ cửa ngõ API. |
| **RFC 7807 Error Handling** | `GlobalExceptionHandler`, `ApiException` | Tự động bắt lỗi và chuyển đổi sang JSON `ProblemDetail` chuẩn mực. |
| **Header Pagination** | `PaginationUtil`, `HeaderUtil` | Tự động tính toán và sinh Header `X-Total-Count`, `Link` cho các API danh sách phân trang. |

---

## 4. Business Flow (Luồng xử lý nghiệp vụ)

```
┌─────────────────────────┐
│     erp_schema.sql      │ ➔ Lược đồ CSDL chuẩn mực của hệ thống ERP
└────────────┬────────────┘
             │ Ánh xạ 1:1
             ▼
┌─────────────────────────┐
│   erp-core-model.jar    │ ➔ 1. BaseAuditingEntity / BaseTenantEntity
│  (Shared Library Core)  │ ➔ 2. Flat ID Entity Model (UUID)
│                         │ ➔ 3. Validation Request DTOs / Response DTOs
└────────────┬────────────┘ ➔ 4. RFC 7807 ProblemDetail Exceptions
             │
             │ mvn clean install (~/.m2/repository)
             ▼
┌─────────────────────────┐
│     backend-service     │ ➔ Consumer quét @EntityScan("com.erp.core.domain")
│   (REST API Service)    │ ➔ Tầng Service xử lý nghiệp vụ & State Machine
└────────────┬────────────┘ ➔ Tầng Mapper thủ công chuyển Entity ⇄ DTO
             │
             │ HTTP / JSON
             ▼
┌─────────────────────────┐
│        frontend         │ ➔ Hiển thị giao diện, bắt lỗi chuẩn RFC 7807
└─────────────────────────┘
```

---

## 5. System Architecture (Kiến trúc hệ thống)

### 5.1. Mô hình Kế thừa Entity (Entity Hierarchy)
```
                  ┌────────────────────────┐
                  │   BaseAuditingEntity   │
                  │ - id (UUID char 36)    │
                  │ - createdAt, updatedAt │
                  │ - createdBy, updatedBy │
                  │ - status (ACTIVE,...)  │
                  └───────────┬────────────┘
                              │
               ┌──────────────┴──────────────┐
               │                             │
    ┌──────────▼──────────┐       ┌──────────▼──────────┐
    │ 8 Bảng Auth & SYS   │       │   BaseTenantEntity  │
    │ (Account, Role,     │       │   - tenantId        │
    │  Permission,...)    │       └──────────┬──────────┘
    └─────────────────────┘                  │
                                  ┌──────────▼──────────┐
                                  │ ~22 Bảng Nghiệp vụ  │
                                  │ (Supplier, PO, INV, │
                                  │  Store, POS,...)    │
                                  └─────────────────────┘
```

### 5.2. Ràng buộc Flat ID Mapping
* Các trường liên kết giữa các bảng được lưu trữ dưới dạng thuộc tính ID đơn thuần (`UUID supplierId`, `UUID purchaseOrderId`).
* **Tuyệt đối KHÔNG sử dụng:** `@OneToMany`, `@ManyToOne`, `@ManyToMany`, `@JoinColumn`, `@JoinTable`.
* Tầng Service của consumer sẽ thực hiện truy vấn và ghép nối dữ liệu theo ID khi chuyển đổi sang `DetailResponse`.

---

## 6. Tech Stack (Công nghệ sử dụng)

* **Ngôn ngữ:** Java 21 LTS.
* **Framework:** Spring Boot 4.1.0 (Core Library).
* **Dependencies:**
  * `spring-boot-starter-data-jpa`: Hỗ trợ JPA Annotations, Auditing Listeners, MappedSuperclass.
  * `spring-boot-starter-validation`: Jakarta Bean Validation API & Hibernate Validator.
* **Build Tool:** Apache Maven 3.6.3+ (Sử dụng `maven-compiler-plugin`).
* **Packaging:** Library JAR thuần túy (Không dùng repackage của Spring Boot plugin).

---

## 7. Repository Structure (Cấu trúc thư mục)

```
core-model/
├── pom.xml                                   # Cấu hình build Maven Library
├── docs/                                     # Tài liệu thiết kế chi tiết
│   ├── README.md                             # Hướng dẫn tích hợp thư viện
│   └── STRUCTURE.md                          # Đặc tả chi tiết từng package & class
├── src/
│   ├── main/
│   │   └── java/com/erp/core/
│   │       ├── CoreApplication.java          # Bootstrap phục vụ Test & Context Scan
│   │       ├── constants/                    # Hằng số hệ thống
│   │       │   ├── Defaults.java             # Giá trị mặc định
│   │       │   ├── MessageKey.java           # Mã khóa i18n
│   │       │   └── TableName.java            # Hằng số tên bảng CSDL (ACCOUNT, SUPPLIER,...)
│   │       ├── domain/                       # Các JPA Entities chuẩn mực
│   │       │   ├── BaseAuditingEntity.java   # Lớp cha kiểm toán dữ liệu
│   │       │   ├── BaseTenantEntity.java     # Lớp cha Multi-tenancy
│   │       │   ├── Account.java              # Tài khoản nội bộ
│   │       │   ├── Role.java                 # Vai trò RBAC
│   │       │   ├── Permission.java           # Quyền nguyên tử
│   │       │   ├── RolePermission.java       # Phân quyền Role - Permission
│   │       │   ├── Scope.java                # Phạm vi chi nhánh/hệ thống
│   │       │   ├── AccountRole.java          # Gán quyền tài khoản theo Scope
│   │       │   └── AuditLog.java             # Nhật ký kiểm toán hệ thống
│   │       ├── dto/                          # Data Transfer Objects
│   │       │   ├── auth/                     # DTOs xác thực (Login, Token)
│   │       │   ├── request/                  # Request DTOs gắn Bean Validation
│   │       │   └── response/                 # Response DTOs (Summary & Detail)
│   │       ├── enums/                        # Enums trạng thái & định danh
│   │       │   ├── EntityStatus.java         # ACTIVE, INACTIVE, DELETED, LOCKED
│   │       │   ├── AuthProvider.java         # LOCAL, GOOGLE,...
│   │       │   ├── RoleType.java             # SYSTEM, TENANT, LOCAL
│   │       │   └── ScopeType.java            # GLOBAL, BRANCH, DEPARTMENT, STORE
│   │       └── web/rest/                     # Hạ tầng RESTful
│   │           ├── errors/                   # ApiException, GlobalExceptionHandler (RFC 7807)
│   │           └── util/                     # PaginationUtil, HeaderUtil
│   └── test/                                 # Unit tests cho context & utilities
```

---

## 8. Getting Started (Bắt đầu nhanh)

### 8.1. Yêu cầu Môi trường
* **Java Development Kit (JDK):** JDK 21 LTS (Oracle JDK, Eclipse Temurin hoặc OpenJDK).
* **Apache Maven:** Phiên bản 3.6.3 trở lên.

### 8.2. Build & Cài đặt vào Local Maven Repository
Mở terminal tại thư mục `core-model`:

```powershell
# 1. Kiểm tra môi trường JDK 21
java -version
mvn -version

# 2. Xóa và cài đặt thư viện vào Local Maven Cache
mvn clean install

# 3. Hoặc chạy chế độ rút gọn log
mvn -q clean install
```

Kết quả: File JAR được tạo tại `target/erp-core-model-0.0.1-SNAPSHOT.jar` và tự động cập nhật vào thư mục `~/.m2/repository/com/erp/erp-core-model/`.

---

## 9. Configuration (Cấu hình)

`core-model` **không chứa cấu hình Datasource** để đảm bảo tính độc lập. Service tiêu thụ (`backend-service`) sẽ tự cấu hình kết nối.

### Hướng dẫn tích hợp vào Service Consumer:
1. **Thêm dependency vào `pom.xml` của Consumer:**
   ```xml
   <dependency>
       <groupId>com.erp</groupId>
       <artifactId>erp-core-model</artifactId>
       <version>0.0.1-SNAPSHOT</version>
   </dependency>
   ```
2. **Kích hoạt quét Entity & Auditing tại Application Class:**
   ```java
   @SpringBootApplication(scanBasePackages = {"com.erp"})
   @EntityScan(basePackages = {"com.erp.core.domain"})
   @EnableJpaAuditing
   public class BackendServiceApplication { ... }
   ```

---

## 10. API Documentation (Quy chuẩn API & DTOs)

### 10.1. Chuẩn hóa Định dạng Lỗi (RFC 7807 Problem Details)
Khi xảy ra lỗi ngoại lệ, `GlobalExceptionHandler` tự động chuyển đổi thành cấu trúc JSON:
```json
{
  "type": "about:blank",
  "title": "Bad Request",
  "status": 400,
  "detail": "Mã nhà cung cấp đã tồn tại trên hệ thống",
  "instance": "/api/v1/suppliers",
  "properties": {
    "code": "PROC_400_SUPPLIER_CODE_EXISTS",
    "timestamp": "2026-08-23T12:00:00Z"
  }
}
```

### 10.2. Chuẩn hóa Phân trang Header
`PaginationUtil.generatePaginationHttpHeaders(Page<?> page, String baseUrl)` tự động tạo các header HTTP:
* `X-Total-Count`: Tổng số lượng bản ghi thỏa mãn điều kiện lọc.
* `Link`: Liên kết phân trang chuẩn RFC 5988 (`first`, `prev`, `next`, `last`).

---

## 11. Security (Bảo mật & Kiểm toán)

* **Bảo vệ Thông tin Nhạy cảm:** Entity `Account` quản lý thông tin tài khoản, tuy nhiên các Response DTOs tuyệt đối không bao gồm password hash hoặc salt.
* **Nhật ký Kiểm toán Toàn diện (`AuditLog`):** Hỗ trợ lưu trữ dữ liệu trước và sau khi thay đổi (`before_data` và `after_data`) dưới dạng trường JSON PostgreSQL (`@JdbcTypeCode(SqlTypes.JSON)`).

---

## 12. Database (Cơ sở dữ liệu & Entity Mapping)

* **Chuẩn Khóa chính:** 100% Entity sử dụng khóa chính dạng chuỗi UUID 36 ký tự (`CHAR(36)`), tự động sinh tại `@PrePersist` nếu chưa có.
* **Hằng số Tên Bảng:** Tuyệt đối không hardcode chuỗi tên bảng trong `@Table`. Bắt buộc gọi qua `TableName.XYZ`.
* **Ánh xạ Cột:** Luôn khai báo `@Column(name = "snake_case", nullable = ..., length = ...)`.
* **Cột Enum:** Bắt buộc gắn `@Enumerated(EnumType.STRING)` và chỉ rõ độ dài `length = 30`.

---

## 13. Testing (Kiểm thử)

```powershell
# Chạy toàn bộ test context và kiểm tra tính tương thích
mvn clean test

# Kiểm tra tính toàn vẹn cú pháp compile
mvn clean compile
```

---

## 14. CI/CD (Tích hợp & Phân phối liên tục)

Trong quy trình CI/CD tổng thể của dự án:
* Khi có commit/merge vào nhánh `dev` của `backend-service`, **Job 1 (Fast Validation)** sẽ tự động checkout `core-model` và thực thi `mvn clean install -DskipTests` để nạp JAR mới nhất vào Maven Cache của Runner trước khi build backend.
* Có thể tích hợp xuất xưởng tự động lên **GitHub Packages (GHCR Maven Registry)** qua lệnh `mvn deploy`.

---

## 15. Deployment (Triển khai & Đóng gói)

* `core-model` đóng gói dạng thư viện tĩnh (`.jar`).
* Không cần container Docker riêng biệt; Thư viện được đóng gói nhúng trực tiếp vào tệp thực thi của `backend-service` khi tạo Docker image của backend.

---

## 16. Monitoring (Giám sát & Nhật ký)

* Cung cấp Entity `AuditLog` ghi nhận đầy đủ: `actorAccountId`, `action`, `resource`, `targetId`, `clientIp`, `occurredAt`, `beforeData`, `afterData`.
* Cho phép các service khác dễ dàng tra cứu lịch sử thay đổi và kiểm toán tuân thủ.

---

## 17. Development / Contribution (Quy chuẩn phát triển & Đóng góp)

### 17.1. Git Flow & Đặt tên Nhánh
* Nhánh gốc checkout: **`dev`**
* Cú pháp nhánh tính năng: `feature/{tên_dev}/{mã_task}` *(Ví dụ: `feature/bao/S2-05`)*
* Cú pháp nhánh sửa lỗi: `fixbug/{tên_dev}/{mã_task}` *(Ví dụ: `fixbug/bao/S2-05`)*
* **Nhánh đích khi tạo Pull Request (Target Branch):** 👉 **`dev`** *(Merge trực tiếp vào `dev` sau khi review)*.

### 17.2. Quy chuẩn Commit Message
* Cú pháp: `feat(mã_task): mô tả` hoặc `fix(mã_task): mô tả`
* *Ví dụ:* `feat(S2-05): add Supplier and SupplierMaterial entities with auditing`

### 17.3. Điều kiện Merge (Definition of Done)
1. 🟢 Có tối thiểu **01 Approval** từ Reviewer (`@hoangdinhdung05` hoặc `@hoan`).
2. 🟢 Resolve 100% review comments.
3. 🟢 Lệnh `mvn clean install` thành công 100% không cảnh báo lỗi.
4. 🟢 Khớp 100% với lược đồ trong `erp_schema.sql`.

---

## 18. Documentation (Tài liệu tham chiếu)

* 📄 [HƯỚNG DẪN TÍCH HỢP CHI TIẾT (docs/README.md)](file:///c:/ERP-UTT/core-model/docs/README.md)
* 📄 [ĐẶC TẢ CẤU TRÚC & CÔNG NĂNG TỪNG LỚP (docs/STRUCTURE.md)](file:///c:/ERP-UTT/core-model/docs/STRUCTURE.md)
* 📄 [QUY CHUẨN PHÁT TRIỂN CORE-MODEL (DEV_GUIDELINES.md)](file:///c:/ERP-UTT/core-model/DEV_GUIDELINES.md)
* 📄 [LƯỢC ĐỒ CSDL CHUẨN (erp_schema.sql)](file:///c:/ERP-UTT/erp_schema.sql)
