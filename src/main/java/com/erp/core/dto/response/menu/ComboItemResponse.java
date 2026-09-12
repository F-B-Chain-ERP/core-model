package com.erp.core.dto.response.menu;

public record ComboItemResponse(
        String comboItemId,
        String variantId,
        String variantCode,
        String variantName,
        String sizeLabel,
        String productCode,
        String productName,
        int quantity,
        boolean isSubstitutable,
        String status
) {
}
