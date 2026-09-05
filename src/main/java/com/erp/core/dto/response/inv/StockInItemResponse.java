package com.erp.core.dto.response.inv;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Read-side projection của dòng chi tiết phiếu nhập kho.
 */
public record StockInItemResponse(
        UUID id,
        String status,
        UUID stockInId,
        UUID purchaseOrderItemId,
        UUID materialId,
        String materialCode,
        String materialName,
        BigDecimal quantity,
        BigDecimal unitPrice,
        String batchNo,
        LocalDate expiryDate
) {
}