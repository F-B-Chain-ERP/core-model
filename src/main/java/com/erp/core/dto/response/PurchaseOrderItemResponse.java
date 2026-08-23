package com.erp.core.dto.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * Read-side projection của dòng chi tiết đơn mua hàng, bao gồm tên nguyên liệu và
 * tên đơn vị tính đã được giải quyết.
 */
public record PurchaseOrderItemResponse(
        String id,
        String status,
        String purchaseOrderId,
        String materialId,
        String materialName,
        BigDecimal quantity,
        String unitId,
        String unitName,
        BigDecimal unitPrice,
        BigDecimal totalPrice,
        BigDecimal receivedQuantity,
        String createdBy,
        Instant createdAt
) {
}
