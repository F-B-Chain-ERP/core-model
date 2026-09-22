package com.erp.core.dto.report.pos;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Lightweight DTO projection used for batch/streaming order export.
 * Shared between backend-service and queue-service to bypass entity tracking and prevent OutOfMemoryError.
 */
public record OrderExportDto(
        UUID id,
        String orderCode,
        Instant createdAt,
        UUID branchId,
        String branchName,
        String customerName,
        String customerPhone,
        String orderType,
        String status,
        String paymentMethod,
        String paymentStatus,
        BigDecimal subtotalAmount,
        BigDecimal discountAmount,
        BigDecimal deliveryFee,
        BigDecimal totalAmount
) {
    public Map<String, Object> toRowMap() {
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("orderCode", orderCode);
        LocalDateTime ldt = createdAt != null
                ? LocalDateTime.ofInstant(createdAt, ZoneId.systemDefault())
                : null;
        row.put("createdAt", ldt);
        row.put("branchName", branchName != null ? branchName : (branchId != null ? branchId.toString() : "-"));
        row.put("customerName", customerName);
        row.put("customerPhone", customerPhone);
        row.put("orderType", orderType);
        row.put("status", status);
        row.put("paymentMethod", (paymentMethod != null && !paymentMethod.isBlank()) ? paymentMethod : "-");
        row.put("paymentStatus", paymentStatus);
        row.put("subtotalAmount", subtotalAmount != null ? subtotalAmount : BigDecimal.ZERO);
        row.put("discountAmount", discountAmount != null ? discountAmount : BigDecimal.ZERO);
        row.put("deliveryFee", deliveryFee != null ? deliveryFee : BigDecimal.ZERO);
        row.put("totalAmount", totalAmount != null ? totalAmount : BigDecimal.ZERO);
        return row;
    }
}
