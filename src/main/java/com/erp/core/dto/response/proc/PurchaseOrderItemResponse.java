package com.erp.core.dto.response.proc;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * Read-side projection của dòng chi tiết đơn mua hàng, bao gồm mã, tên nguyên vật liệu,
 * tên đơn vị tính và số lượng đã nhận (khớp hợp đồng SRS 3.7).
 */
public record PurchaseOrderItemResponse(
        String id,
        String status,
        String purchaseOrderId,
        String materialId,
        String materialCode,
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
