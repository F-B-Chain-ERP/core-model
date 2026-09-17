package com.erp.core.dto.request.store;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu phân công lịch ca hàng loạt cho nhiều nhân viên/ngày.
 */
public record BulkAssignShiftRequest(
        @NotNull(message = "Chi nhánh không được để trống")
        UUID branchId,

        @NotEmpty(message = "Danh sách phân ca không được để trống")
        List<@Valid AssignmentItem> assignments
) {
    public record AssignmentItem(
            @NotNull(message = "Ca làm việc không được để trống")
            UUID shiftId,

            @NotNull(message = "Nhân viên không được để trống")
            UUID accountId,

            @NotNull(message = "Ngày làm việc không được để trống")
            LocalDate workDate,

            @Size(max = 255, message = "Ghi chú tối đa 255 ký tự")
            String note
    ) {}
}
