package com.erp.core.dto.request.branch;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;

/**
 * DTO yêu cầu tự động sinh danh sách các khung giờ pickup liên tiếp nhau.
 */
public record GeneratePickupSlotsRequest(
        @NotNull(message = "Giờ bắt đầu ngày không được để trống")
        LocalTime startTime,

        @NotNull(message = "Giờ kết thúc ngày không được để trống")
        LocalTime endTime,

        @NotNull(message = "Bước nhảy thời gian (phút) không được để trống")
        @Min(value = 15, message = "Bước nhảy tối thiểu 15 phút")
        @Max(value = 120, message = "Bước nhảy tối đa 120 phút")
        Integer stepMinutes,

        @Min(value = 1, message = "Số lượng đơn tối đa phải lớn hơn hoặc bằng 1")
        Integer maxOrders
) {
}
