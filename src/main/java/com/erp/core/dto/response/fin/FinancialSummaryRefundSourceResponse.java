package com.erp.core.dto.response.fin;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Dòng dữ liệu nguồn Refund (status = PROCESSED) dùng để đối soát doanh thu thuần.
 */
public record FinancialSummaryRefundSourceResponse(
        String refundId,
        String refundCode,
        String orderId,
        Instant processedAt,
        BigDecimal amount
) {
}