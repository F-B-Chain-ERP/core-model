package com.erp.core.dto.response.fin;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * Read-side projection chi tiết {@code AccountsPayable} — hiển thị trong drawer/chi tiết,
 * bao gồm danh sách lịch sử thanh toán.
 */
public record AccountsPayableDetailResponse(
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
        Instant createdAt,
        List<PayablePaymentResponse> payments
) {
}
