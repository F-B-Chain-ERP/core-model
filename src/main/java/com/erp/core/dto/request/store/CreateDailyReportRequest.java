package com.erp.core.dto.request.store;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Yêu cầu khởi tạo báo cáo ngày của chi nhánh.
 */
public record CreateDailyReportRequest(
        @NotNull(message = "Chi nhánh không được để trống")
        UUID branchId,

        @NotNull(message = "Ngày báo cáo không được để trống")
        LocalDate businessDate,

        @PositiveOrZero(message = "Tiền mở két ngày phải >= 0")
        BigDecimal openingCash,

        @Size(max = 500, message = "Ghi chú tối đa 500 ký tự")
        String note
) {
}
