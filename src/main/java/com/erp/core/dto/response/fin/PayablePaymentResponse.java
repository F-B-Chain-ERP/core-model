package com.erp.core.dto.response.fin;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * Read-side projection của {@code AccountsPayablePayment} — hiển thị lịch sử thanh toán.
 */
public record PayablePaymentResponse(
        String id,
        LocalDate paymentDate,
        BigDecimal amount,
        String paymentMethod,
        String referenceNo,
        String createdBy,
        Instant createdAt
) {
}
