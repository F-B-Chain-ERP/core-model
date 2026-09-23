package com.erp.core.dto.response.fin;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Dòng dữ liệu nguồn Order dùng để đối soát COGS/doanh thu của một báo cáo tài chính ngày.
 */
public record FinancialSummaryOrderSourceResponse(
        String orderId,
        String orderCode,
        Instant completedAt,
        BigDecimal subtotalAmount,
        BigDecimal discountAmount,
        BigDecimal totalCogsAmount
) {
}