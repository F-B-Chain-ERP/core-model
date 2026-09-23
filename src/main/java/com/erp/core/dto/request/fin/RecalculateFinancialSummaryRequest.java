package com.erp.core.dto.request.fin;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO yêu cầu tính lại báo cáo tài chính (Financial Summary) theo chi nhánh và ngày kinh doanh.
 */
public record RecalculateFinancialSummaryRequest(

        @NotNull(message = "Chi nhánh không được để trống")
        UUID branchId,

        @NotNull(message = "Ngày kinh doanh không được để trống")
        LocalDate businessDate
) {
}