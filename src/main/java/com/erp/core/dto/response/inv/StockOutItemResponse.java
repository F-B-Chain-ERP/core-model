package com.erp.core.dto.response.inv;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Read-side projection của dòng chi tiết phiếu xuất kho.
 */
public record StockOutItemResponse(
        UUID id,
        String status,
        UUID stockOutId,
        UUID materialId,
        String materialCode,
        String materialName,
        BigDecimal quantity,
        BigDecimal unitPrice,
        String batchNo
) {
}