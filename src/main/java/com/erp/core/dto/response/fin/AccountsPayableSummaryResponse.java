package com.erp.core.dto.response.fin;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * Read-side projection của {@code AccountsPayable} — hiển thị trong danh sách.
 */
public record AccountsPayableSummaryResponse(
        String id,
        String supplierId,
        String supplierCode,
        String supplierName,
        String purchaseOrderId,
        String poCode,
        String invoiceNo,
        BigDecimal invoiceAmount,
        BigDecimal paidAmount,
        BigDecimal remainingAmount,
        LocalDate receivedDate,
        LocalDate dueDate,
        Integer paymentTermDays,
        LocalDate invoiceDate,
        String status,
        String note,
        Instant createdAt
) {
}
