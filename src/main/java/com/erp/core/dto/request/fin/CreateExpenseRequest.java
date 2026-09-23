package com.erp.core.dto.request.fin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO yêu cầu tạo mới khoản chi phí vận hành (Expense).
 * branchId có thể null để ghi nhận chi phí trung tâm (chưa phân bổ cho chi nhánh).
 */
public record CreateExpenseRequest(

        UUID branchId,

        @NotNull(message = "Ngày chi phí không được để trống")
        LocalDate expenseDate,

        @NotBlank(message = "Loại chi phí không được để trống")
        @Size(max = 50, message = "Loại chi phí tối đa 50 ký tự")
        String expenseCategory,

        @NotNull(message = "Số tiền chi phí không được để trống")
        @PositiveOrZero(message = "Số tiền chi phí phải lớn hơn hoặc bằng 0")
        BigDecimal amount,

        @Size(max = 500, message = "Mô tả tối đa 500 ký tự")
        String description
) {
}