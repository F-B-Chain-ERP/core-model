package com.erp.core.dto.response.proc;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * Read-side projection của {@code PurchaseOrder}, bao gồm thông tin nhà cung cấp, kho nhận,
 * người phê duyệt và danh sách dòng chi tiết (khớp hợp đồng SRS 3.7).
 */
public record PurchaseOrderResponse(
        String id,
        String poCode,
        String status,
        LocalDate orderDate,
        LocalDate expectedDate,
        PurchaseOrderSupplierResponse supplier,
        PurchaseOrderWarehouseResponse warehouse,
        BigDecimal subtotalAmount,
        BigDecimal totalAmount,
        String note,
        Instant submittedAt,
        ApprovedByResponse approvedBy,
        Instant approvedAt,
        Instant cancelledAt,
        String cancelReason,
        List<PurchaseOrderItemResponse> items,
        String createdBy,
        Instant createdAt
) {
}
