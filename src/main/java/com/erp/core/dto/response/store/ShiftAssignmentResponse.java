package com.erp.core.dto.response.store;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Phản hồi chi tiết lịch phân ca làm việc của nhân viên.
 */
public record ShiftAssignmentResponse(
        UUID id,
        UUID shiftId,
        String shiftCode,
        String shiftName,
        LocalTime startTime,
        LocalTime endTime,
        UUID branchId,
        UUID accountId,
        String employeeName,
        String employeeEmail,
        LocalDate workDate,
        String status,
        Instant checkInAt,
        Instant checkOutAt,
        BigDecimal initialCash,
        BigDecimal finalCash,
        BigDecimal cashDifference,
        String note,
        Instant createdAt
) {
}
