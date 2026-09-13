package com.erp.core.dto.response.menu;

import java.math.BigDecimal;
import java.util.List;

public record CalculateComboPriceResponse(
        BigDecimal originalComboPrice,
        BigDecimal adjustedComboPrice,
        List<ItemPriceDetail> details
) {
    public record ItemPriceDetail(
            String comboItemId,
            String originalVariantId,
            String newVariantId,
            BigDecimal originalLineTotal,
            BigDecimal adjustedLineTotal,
            BigDecimal priceDifference
    ) {
    }
}
