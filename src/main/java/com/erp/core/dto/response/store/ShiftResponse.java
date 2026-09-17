package com.erp.core.dto.response.store;

import java.time.Instant;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Phản hồi thông tin khung ca làm việc chuẩn.
 */
public record ShiftResponse(
        UUID id,
        UUID branchId,
        String shiftCode,
        String shiftName,
        LocalTime startTime,
        LocalTime endTime,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
}
