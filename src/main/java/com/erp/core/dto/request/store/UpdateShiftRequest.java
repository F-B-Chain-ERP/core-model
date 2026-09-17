package com.erp.core.dto.request.store;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;

/**
 * Yêu cầu cập nhật thông tin khung ca làm việc.
 */
public record UpdateShiftRequest(
        @NotBlank(message = "Tên ca không được để trống")
        @Size(max = 100, message = "Tên ca tối đa 100 ký tự")
        String shiftName,

        @NotNull(message = "Giờ bắt đầu không được để trống")
        LocalTime startTime,

        @NotNull(message = "Giờ kết thúc không được để trống")
        LocalTime endTime,

        @Size(max = 30, message = "Trạng thái tối đa 30 ký tự")
        String status
) {
}
