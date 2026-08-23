# 📦 HƯỚNG DẪN & QUY CHUẨN PHÁT TRIỂN REPOSITORY `core-model`
## DÀNH RIÊNG CHO DEV PHÁT TRIỂN CORE DOMAIN, ENTITIES & DTOS

---

## 🌿 1. QUY ĐỊNH GIT FLOW & NHÁNH LÀM VIỆC (BRANCHING RULES)

### 1.1. Cú pháp đặt tên nhánh (Checkout từ nhánh `dev`)
Tất cả các nhánh làm việc bắt buộc phải được **checkout từ nhánh `dev`**:

* **Task tính năng / Model mới:**
  $$\mathbf{feature/\{\text{tên\_dev}\}/\{\text{mã\_task}\}}$$
  *Ví dụ:* `feature/bao/S2-05`, `feature/vinh/S2-06`
* **Task sửa lỗi Model / DTO:**
  $$\mathbf{fixbug/\{\text{tên\_dev}\}/\{\text{mã\_task}\}} \quad \text{hoặc} \quad \mathbf{fixbug/\{\text{tên\_dev}\}/\{\text{mã\_bug}\}}$$
  *Ví dụ:* `fixbug/bao/S2-05`, `fixbug/vinh/S2-BUG-02`
* **Tối ưu / Refactor:**
  $$\mathbf{refactor/\{\text{tên\_dev}\}/\{\text{mã\_task}\}}$$

---

### 1.2. Quy định Nhánh đích khi tạo Pull Request (Target Branch)
> [!IMPORTANT]
> **Nhánh đích khi tạo PR:** 👉 **`dev`** *(Merge trực tiếp vào `dev`)*  
> **Lý do:** `core-model` là thư viện nền tảng chứa Domain Model, DTOs dùng chung cho cả hệ sinh thái. Khi hoàn thành và được Reviewer phê duyệt, PR phải được **merge trực tiếp vào nhánh `dev`** để backend và các module khác pull về build jar local.

---

### 1.3. Quy tắc Commit Message (Conventional Commits)
- **Cú pháp:** `feat(mã_task): mô tả` hoặc `fix(mã_task): mô tả`
- *Ví dụ:*
  - `feat(S2-05): add Supplier and SupplierMaterial entities with auditing`
  - `feat(S2-06): add PurchaseOrder and PurchaseOrderItem entities with DTOs`
  - `fix(S2-05): add missing @NotBlank validation in CreateSupplierRequest`

---

## 🛠 2. QUY CHUẨN CODE (CODING STANDARDS CHO CORE-MODEL)

Dựng theo base code và kiến trúc hiện hữu của `core-model`:

### 2.1. Chuẩn Entity JPA/Hibernate (`com.erp.core.domain`)

1. **Kế thừa Base Entity:**
   - Tất cả Entity nghiệp vụ **bắt buộc kế thừa** `BaseAuditingEntity`.
   - Cung cấp sẵn: `id` (`UUID` tự sinh ngẫu nhiên tại `@PrePersist`), `createdAt`, `updatedAt`, `createdBy`, `updatedBy`.
   - Nếu là entity đa tenant/chi nhánh, kế thừa `BaseTenantEntity`.
2. **Ánh xạ bảng (Table Mapping):**
   - Không hardcode tên bảng dạng chuỗi. Bắt buộc khai báo hằng số trong `com.erp.core.constants.TableName` và gọi qua `TableName.XYZ`.
   ```java
   @Entity
   @Table(name = TableName.SUPPLIER)
   public class Supplier extends BaseAuditingEntity { ... }
   ```
3. **Ánh xạ cột (Column Mapping):**
   - `@Column(name = "snake_case", nullable = ..., length = ...)` cho từng field.
   - Luôn chỉ rõ `length` cho các cột chuỗi (ví dụ: `length = 50`, `100`, `255`, `500`).
   - Cột dạng Enum **bắt buộc dùng** `@Enumerated(EnumType.STRING)` và `@Column(name = "...", length = 30)`.
4. **Lưu ID đơn thuần — TUYỆT ĐỐI KHÔNG DÙNG `@OneToMany`, `@ManyToOne`, `@ManyToMany`:**
   > [!WARNING]
   > **Kiến trúc Flat ID Mapping (Đặc thù của dự án):**
   > - Trong `core-model`, Entity **chỉ lưu trường ID đơn thuần** (dạng `UUID`), ví dụ: `supplierId`, `warehouseId`, `purchaseOrderId`, `materialId`, `unitId`, `accountId`, `roleId`.
   > - **TUYỆT ĐỐI KHÔNG** khai báo các quan hệ đối tượng lồng nhau như `@OneToMany`, `@ManyToOne`, `@ManyToMany`, `@JoinColumn` hay `@JoinTable` (để tránh lỗi N+1 Query, Cascade ẩn, vòng lặp tuần tự hóa JSON và phụ thuộc vòng giữa các domain).
   > - Mọi việc ghép nối dữ liệu, join query hoặc map sang DTO chi tiết sẽ do tầng **Service / Repository / Mapper** bên `backend-service` tự thực hiện thông qua ID.
   > - **Entity mẫu chuẩn tham chiếu:** Xem [`AccountRole.java`](file:///c:/ERP-UTT/core-model/src/main/java/com/erp/core/domain/AccountRole.java) (`accountId`, `roleId`, `scopeId`), [`RolePermission.java`](file:///c:/ERP-UTT/core-model/src/main/java/com/erp/core/domain/RolePermission.java) (`roleId`, `permissionId`), [`AuditLog.java`](file:///c:/ERP-UTT/core-model/src/main/java/com/erp/core/domain/AuditLog.java) (`actorAccountId`, `targetId`).

---

### 2.2. Chuẩn Enums & Constants
- **Enums (`com.erp.core.enums`):** Viết hoa `UPPER_SNAKE_CASE` (ví dụ: `SupplierStatus.ACTIVE`, `PurchaseOrderStatus.DRAFT`).
- **Constants (`com.erp.core.constants`):** Khai báo tập trung trong `TableName.java`, `Defaults.java`,...

---

### 2.3. Chuẩn DTOs (Request / Response) (`com.erp.core.dto.*`)
- Tổ chức theo package phân hệ (ví dụ: `com.erp.core.dto.proc.*`, `com.erp.core.dto.request.supplier.*`, `com.erp.core.dto.response.supplier.*`).
- **Request DTOs:** Bắt buộc gắn đầy đủ Jakarta Bean Validation:
  - `@NotBlank(message = "Mã nhà cung cấp không được để trống")`
  - `@Size(max = 50, message = "Mã tối đa 50 ký tự")`
  - `@Email`, `@Pattern`, `@NotNull`, `@Min(0)`, `@PositiveOrZero`.
- **Response DTOs:** Tách biệt rõ:
  - `XxxResponse` / `XxxSummaryResponse`: Phục vụ hiển thị danh sách (nhẹ, ít join).
  - `XxxDetailResponse`: Phục vụ xem chi tiết (đầy đủ quan hệ cha - con, danh sách phụ).

---

## 🔄 3. QUY TRÌNH BUILD & SYNC SANG BACKEND
Sau khi tạo hoặc chỉnh sửa code trong `core-model`:

1. **Build & cài đặt thư viện vào Maven Local:**
   ```bash
   mvn clean install
   ```
2. Thao tác này sẽ cập nhật `core-model-*.jar` vào thư mục `~/.m2/repository/com/erp/core-model/`.
3. Mở project `backend-service` $\rightarrow$ Reload Maven Dependencies để nhận code mới nhất.

---

## 🛡 4. QUY ĐỊNH TẠO PULL REQUEST & CODE REVIEW

### 4.1. Reviewer bắt buộc
Khi tạo Pull Request, Dev **bắt buộc gán Reviewer**:
- 👤 `hoangdinhdung05`
- 👤 `Hoàn`

---

### 4.2. Mẫu PR Description (PR Template)
```markdown
### 📌 [MÃ TASK] - TÊN ENTITY / DTO CORE-MODEL
- **Repo:** core-model
- **Nhánh:** `feature/tên_dev/mã_task` ➔ **Target:** `dev`
- **Tác giả:** [Tên Dev]
- **Reviewer:** @hoangdinhdung05, @hoan

---

### 📝 Chi tiết thay đổi
- [x] Tạo Entity: `Supplier.java`, `SupplierMaterial.java` (kế thừa `BaseAuditingEntity`).
- [x] Khai báo Enum: `SupplierStatus.java`, hằng số `TableName.SUPPLIER`.
- [x] Tạo DTOs: `CreateSupplierRequest.java`, `SupplierResponse.java`, `SupplierDetailResponse.java`.
- [x] Đã cấu hình đầy đủ Jakarta Bean Validation annotations.

---

### 🧪 Bằng chứng kiểm thử (Evidence)
- [x] Đã chạy `mvn clean compile` và `mvn clean install` thành công 100% không có lỗi.
- [x] Đã kiểm tra khớp 100% với cấu trúc bảng trong `erp_schema.sql`.

---

### ⚠️ Lưu ý CSDL (nếu có)
- [ ] Bảng mới `supplier`, `supplier_material` đã được đồng bộ trong `erp_schema.sql`.
```

---

### 4.3. Điều kiện Tiên quyết để Merge (Definition of Done PR)
1. 🟢 Có **tối thiểu 01 Approval** từ `hoangdinhdung05` hoặc `Hoàn`.
2. 🟢 Resolve 100% review comments.
3. 🟢 Lệnh `mvn clean install` build pass 100%.
4. 🟢 Không có xung đột (No merge conflict) với nhánh `dev`.
