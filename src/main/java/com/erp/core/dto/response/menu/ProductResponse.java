package com.erp.core.dto.response.menu;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO response danh sách và chi tiết sản phẩm cho quản trị (Admin ERP).
 */
public record ProductResponse(
        /** ID sản phẩm (UUID dạng chuỗi). */
        String id,

        /** Mã sản phẩm (ví dụ: CF-PHIN-SUA). */
        String code,

        /** Tên sản phẩm. */
        String name,

        /** Mô tả chi tiết món. */
        String description,

        /** Đường dẫn ảnh sản phẩm. */
        String imageUrl,

        /** ID danh mục cha. */
        String categoryId,

        /** Tên danh mục cha. */
        String categoryName,

        /** Giá bán cơ bản. */
        BigDecimal basePrice,

        /** Thời gian chuẩn bị dự kiến (phút). */
        int preparationMinutes,

        /** Sản phẩm nổi bật. */
        boolean isFeatured,

        /** Sản phẩm bán chạy. */
        boolean isBestSeller,

        /** Sản phẩm dạng combo hay món đơn. */
        boolean isCombo,

        /** Các mức đá khả dụng (dạng chuỗi csv, ví dụ: 0,30,50,70,100). */
        String availableIceLevels,

        /** Các mức đường khả dụng (dạng chuỗi csv, ví dụ: 0,30,50,70,100). */
        String availableSugarLevels,

        /** Trạng thái (ACTIVE, INACTIVE, ARCHIVED...). */
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
