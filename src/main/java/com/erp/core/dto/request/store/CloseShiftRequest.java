package com.erp.core.dto.request.store;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * Yêu cầu đóng ca làm việc, kiểm đếm két và gửi biên bản chốt ca.
 */
public record CloseShiftRequest(
        @NotNull(message = "Số tiền kiểm đếm thực tế không được để trống")
        @PositiveOrZero(message = "Số tiền kiểm đếm thực tế phải lớn hơn hoặc bằng 0")
        BigDecimal actualCash,

        @PositiveOrZero(message = "Số tiền chi quỹ phải lớn hơn hoặc bằng 0")
        BigDecimal cashPayout,

        @Size(max = 500, message = "Lý do chênh lệch tối đa 500 ký tự")
        String differenceReason,

        String cashDenominations,

        @Size(max = 500, message = "Ghi chú tối đa 500 ký tự")
        String note
) {
}
