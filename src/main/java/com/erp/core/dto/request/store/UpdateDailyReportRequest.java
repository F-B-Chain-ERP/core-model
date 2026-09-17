package com.erp.core.dto.request.store;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * Yêu cầu cập nhật hoặc gửi duyệt báo cáo ngày của chi nhánh.
 */
public record UpdateDailyReportRequest(
        @PositiveOrZero(message = "Tiền mở két ngày phải >= 0")
        BigDecimal openingCash,

        @PositiveOrZero(message = "Tiền đóng két ngày phải >= 0")
        BigDecimal closingCash,

        @Size(max = 30, message = "Trạng thái tối đa 30 ký tự")
        String status,

        @Size(max = 500, message = "Ghi chú tối đa 500 ký tự")
        String note
) {
}
