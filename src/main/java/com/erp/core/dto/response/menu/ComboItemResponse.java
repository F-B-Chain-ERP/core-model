package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

/**
 * Thành phần của combo. Nguồn dữ liệu: combo_item -> product_variant -> product.
 * Dùng chung cho Admin (ComboMapper) và kênh bán hàng POS/web (ComboSalesService).
 */
public record ComboItemResponse(
        String comboItemId,
        String variantId,
        String variantCode,
        String variantName,
        String sizeLabel,
        String productId,
        String productCode,
        String productName,
        BigDecimal variantPrice,
        int quantity,
        boolean isSubstitutable,
        String status,
        BigDecimal lineTotal
) {
}