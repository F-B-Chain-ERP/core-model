package com.erp.core.dto.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO phía response (read-side projection) biểu diễn một liên kết bảng giá nhà cung cấp -
 * nguyên vật liệu, đã được giải quyết tên để hiển thị trực tiếp trên giao diện.
 *
 * <p>Do dự án áp dụng quy tắc <b>Flat ID Mapping</b> (thực thể chỉ lưu {@code UUID}, không
 * join quan hệ), {@code supplierName} và {@code materialName} được tầng Service truy vấn và
 * điền vào, giúp frontend không phải gọi thêm API để tra tên.</p>
 */
public record SupplierMaterialResponse(

        /** ID bản ghi (UUID dạng chuỗi). */
        String id,

        /** ID nhà cung cấp (UUID dạng chuỗi). */
        String supplierId,

        /** Tên nhà cung cấp (đã giải quyết từ {@code supplierId}). */
        String supplierName,

        /** ID nguyên vật liệu (UUID dạng chuỗi). */
        String materialId,

        /** Tên nguyên vật liệu (đã giải quyết từ {@code materialId}). */
        String materialName,

        /** Mã hàng hóa riêng của nhà cung cấp (nếu có). */
        String supplierSku,

        /** Giá mua của nguyên vật liệu từ nhà cung cấp này. */
        BigDecimal purchasePrice,

        /** Thời gian giao hàng dự kiến (ngày). */
        Integer leadTimeDays,

        /** {@code true} nếu nhà cung cấp này là ưu tiên cho nguyên vật liệu. */
        boolean isPreferred,

        /** Trạng thái bản ghi (ACTIVE/INACTIVE). */
        String status,

        /** Người tạo bản ghi. */
        String createdBy,

        /** Thời điểm tạo. */
        Instant createdAt,

        /** Người cập nhật gần nhất. */
        String updatedBy,

        /** Thời điểm cập nhật gần nhất. */
        Instant updatedAt
) {
}
