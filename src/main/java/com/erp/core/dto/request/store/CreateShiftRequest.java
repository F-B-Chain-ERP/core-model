package com.erp.core.dto.request.store;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;
import java.util.UUID;

/**
 * Yêu cầu tạo mới khung ca làm việc chuẩn (Shift Template).
 */
public record CreateShiftRequest(
        @NotNull(message = "Chi nhánh không được để trống")
        UUID branchId,

        @NotBlank(message = "Mã ca không được để trống")
        @Size(max = 50, message = "Mã ca tối đa 50 ký tự")
        String shiftCode,

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
