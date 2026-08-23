package com.erp.core.dto.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * Read-side projection của {@code PurchaseOrder}, bao gồm tên nhà cung cấp, tên kho
 * và danh sách dòng chi tiết đã giải quyết tên.
 */
public record PurchaseOrderResponse(
        String id,
        String poCode,
        String supplierId,
        String supplierName,
        String warehouseId,
        String warehouseName,
        String status,
        LocalDate orderDate,
        LocalDate expectedDate,
        BigDecimal subtotalAmount,
        BigDecimal totalAmount,
        String note,
        Instant submittedAt,
        String approvedBy,
        Instant approvedAt,
        Instant cancelledAt,
        String cancelReason,
        List<PurchaseOrderItemResponse> items,
        String createdBy,
        Instant createdAt
) {
}
