package com.erp.core.dto.response.fin;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * Read-side projection của {@code BranchDailyFinancialSummary} — hiển thị báo cáo tổng hợp tài chính ngày của chi nhánh.
 */
public record FinancialSummaryResponse(
        String id,
        String branchId,
        String branchName,
        LocalDate businessDate,
        BigDecimal grossRevenue,
        BigDecimal discountAmount,
        BigDecimal netRevenue,
        BigDecimal totalCogs,
        BigDecimal grossProfit,
        BigDecimal totalExpense,
        BigDecimal netProfit,
        Integer orderCount,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
}