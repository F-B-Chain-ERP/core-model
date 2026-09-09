package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

/**
 * DTO response danh sách sản phẩm cho kênh bán hàng (Sales channel / Store POS & Web).
 * Dùng cho endpoint public, chỉ chứa các sản phẩm ACTIVE kèm thông tin chi tiết (ice, sugar, category...).
 */
public record ProductSalesResponse(
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

        /** Trạng thái (ACTIVE). */
        String status
) {
}
