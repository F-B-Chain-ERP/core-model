package com.erp.core.dto.response.menu;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO tổng hợp thông tin BOM của biến thể sản phẩm dùng cho màn hình danh sách BOM.
 */
public record ProductBomOverviewResponse(
        /** ID biến thể sản phẩm. */
        String variantId,

        /** Mã biến thể sản phẩm. */
        String variantCode,

        /** Tên biến thể sản phẩm (Size S, M, L...). */
        String variantName,

        /** ID sản phẩm gốc. */
        String productId,

        /** Mã sản phẩm (DRK-CF-01...). */
        String productCode,

        /** Tên sản phẩm. */
        String productName,

        /** Tên danh mục món. */
        String categoryName,

        /** Giá bán niêm yết (basePrice + priceDelta). */
        BigDecimal sellingPrice,

        /** Số lượng nguyên vật liệu đã cấu hình trong định lượng. */
        int itemCount,

        /** Trạng thái biến thể (ACTIVE, INACTIVE). */
        String status,

        /** Thời điểm cập nhật gần nhất. */
        Instant updatedAt
) {
}
