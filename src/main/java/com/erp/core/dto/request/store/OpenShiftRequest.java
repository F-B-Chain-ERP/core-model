package com.erp.core.dto.request.store;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * Yêu cầu mở ca làm việc & tiếp nhận tiền thối đầu ca.
 */
public record OpenShiftRequest(
        @NotNull(message = "Số tiền đầu ca không được để trống")
        @PositiveOrZero(message = "Số tiền đầu ca phải lớn hơn hoặc bằng 0")
        BigDecimal initialCash,

        @Size(max = 255, message = "Ghi chú tối đa 255 ký tự")
        String note
) {
}
