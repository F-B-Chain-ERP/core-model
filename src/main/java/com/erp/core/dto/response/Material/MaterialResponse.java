package com.erp.core.dto.response.Material;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO phía response biểu diễn một nguyên vật liệu (master data).
 *
 * <p>Cho danh sách (list): {@code categoryName}, {@code unitName} có thể {@code null}
 * vì không join tên. Cho chi tiết (detail): các trường này được điền đầy đủ.</p>
 */
public record MaterialResponse(

        /** ID nguyên vật liệu (UUID dạng chuỗi). */
        String id,

        /** Mã nguyên vật liệu. */
        String code,

        /** Tên nguyên vật liệu. */
        String name,

        /** ID nhóm nguyên vật liệu (UUID dạng chuỗi). */
        String categoryId,

        /** Tên nhóm nguyên vật liệu (chỉ có khi query detail). */
        String categoryName,

        /** ID đơn vị tính cơ bản (UUID dạng chuỗi). */
        String baseUnitId,

        /** Tên đơn vị tính cơ bản (chỉ có khi query detail). */
        String unitName,

        /** Ngưỡng cảnh báo tồn tối thiểu. */
        BigDecimal minStockAlert,

        /** Số ngày sử dụng (hàng dễ hỏng). */
        Integer shelfLifeDays,

        /** Hàng dễ hỏng hay không. */
        boolean isPerishable,

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
