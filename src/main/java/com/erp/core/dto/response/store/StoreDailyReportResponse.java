package com.erp.core.dto.response.store;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Phản hồi chi tiết báo cáo ngày của chi nhánh.
 */
public record StoreDailyReportResponse(
        UUID id,
        UUID branchId,
        LocalDate businessDate,
        BigDecimal openingCash,
        BigDecimal closingCash,
        Integer totalOrders,
        BigDecimal grossRevenue,
        BigDecimal discountAmount,
        BigDecimal netRevenue,
        BigDecimal cashAmount,
        BigDecimal transferAmount,
        BigDecimal cashPayout,
        String status,
        UUID submittedById,
        String submittedByName,
        Instant submittedAt,
        Instant createdAt,
        Instant updatedAt
) {
}
