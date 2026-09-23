package com.erp.core.dto.response.fin;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * Read-side projection của {@code Expense} — hiển thị trong danh sách / chi tiết chi phí vận hành.
 */
public record ExpenseResponse(
        String id,
        String branchId,
        String branchName,
        LocalDate expenseDate,
        String expenseCategory,
        BigDecimal amount,
        String description,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
}