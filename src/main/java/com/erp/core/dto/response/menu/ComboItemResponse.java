package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

public record ComboItemResponse(
        String comboItemId,
        String variantId,
        String variantCode,
        String variantName,
        String sizeLabel,
        String productCode,
        String productName,
        BigDecimal variantPrice,
        int quantity,
        boolean isSubstitutable,
        String status,
        BigDecimal lineTotal
) {
}
