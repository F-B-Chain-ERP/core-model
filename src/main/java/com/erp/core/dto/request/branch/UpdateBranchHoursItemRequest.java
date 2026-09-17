package com.erp.core.dto.request.branch;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;

/**
 * DTO yêu cầu cập nhật giờ mở/đóng cửa cho một ngày cụ thể (1=Thứ Hai..7=Chủ Nhật).
 */
public record UpdateBranchHoursItemRequest(
        @NotNull(message = "Thứ trong tuần không được để trống")
        @Min(value = 1, message = "Thứ trong tuần phải từ 1 (Thứ 2) đến 7 (Chủ Nhật)")
        @Max(value = 7, message = "Thứ trong tuần phải từ 1 (Thứ 2) đến 7 (Chủ Nhật)")
        Integer dayOfWeek,

        LocalTime openTime,

        LocalTime closeTime,

        boolean isClosed,

        String status
) {
}
