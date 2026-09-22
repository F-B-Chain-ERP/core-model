package com.erp.core.dto.report.pos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Aggregated DTO projection for POS sales summary by product and variant.
 * Computed directly in DB via GROUP BY to avoid loading hundreds of thousands of OrderItems into heap.
 */
public record ProductSalesSummaryDto(
        String productCode,
        String productName,
        String variantName,
        Long totalQuantity,
        BigDecimal totalRevenue,
        BigDecimal totalCogs
) {
    public Map<String, Object> toRowMap() {
        int qty = totalQuantity != null ? totalQuantity.intValue() : 0;
        BigDecimal rev = totalRevenue != null ? totalRevenue : BigDecimal.ZERO;
        BigDecimal cogs = totalCogs != null ? totalCogs : BigDecimal.ZERO;
        BigDecimal grossProfit = rev.subtract(cogs);
        BigDecimal unitPrice = rev.divide(BigDecimal.valueOf(Math.max(qty, 1)), 2, RoundingMode.HALF_UP);
        BigDecimal profitMargin = rev.signum() != 0
                ? grossProfit.multiply(BigDecimal.valueOf(100)).divide(rev, 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;

        Map<String, Object> row = new LinkedHashMap<>();
        row.put("productCode", productCode != null ? productCode : "");
        row.put("productName", productName != null ? productName : "");
        row.put("variantName", variantName != null ? variantName : "");
        row.put("quantity", qty);
        row.put("unitPrice", unitPrice);
        row.put("revenue", rev);
        row.put("cogs", cogs);
        row.put("grossProfit", grossProfit);
        row.put("profitMargin", profitMargin.setScale(1, RoundingMode.HALF_UP).toPlainString() + "%");
        return row;
    }
}
