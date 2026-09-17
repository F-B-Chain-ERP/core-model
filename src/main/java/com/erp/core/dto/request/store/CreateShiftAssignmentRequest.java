package com.erp.core.dto.request.store;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Yêu cầu phân công nhân viên vào ca làm việc cụ thể.
 */
public record CreateShiftAssignmentRequest(
        @NotNull(message = "Ca làm việc không được để trống")
        UUID shiftId,

        @NotNull(message = "Chi nhánh không được để trống")
        UUID branchId,

        @NotNull(message = "Nhân viên không được để trống")
        UUID accountId,

        @NotNull(message = "Ngày làm việc không được để trống")
        LocalDate workDate,

        @Size(max = 255, message = "Ghi chú tối đa 255 ký tự")
        String note
) {
}
