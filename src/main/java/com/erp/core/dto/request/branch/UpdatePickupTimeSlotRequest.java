package com.erp.core.dto.request.branch;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalTime;

/**
 * DTO cập nhật khung giờ pickup cho chi nhánh.
 */
public record UpdatePickupTimeSlotRequest(
        @NotBlank(message = "Mã khung giờ không được để trống")
        @Size(max = 50, message = "Mã khung giờ tối đa 50 ký tự")
        String slotCode,

        @NotNull(message = "Giờ bắt đầu không được để trống")
        LocalTime startTime,

        @NotNull(message = "Giờ kết thúc không được để trống")
        LocalTime endTime,

        @Min(value = 1, message = "Số lượng đơn tối đa phải lớn hơn hoặc bằng 1")
        Integer maxOrders,

        String status
) {
}
