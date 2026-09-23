package com.erp.core.dto.response.fin;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Dòng dữ liệu nguồn Expense (status = ACTIVE) dùng để đối soát tổng chi phí vận hành.
 */
public record FinancialSummaryExpenseSourceResponse(
        String expenseId,
        String expenseCategory,
        BigDecimal amount,
        LocalDate expenseDate,
        String description
) {
}