package com.erp.core.dto.response.branch;

import java.time.LocalTime;
import java.util.UUID;

/**
 * Phản hồi thông tin cấu hình giờ mở/đóng cửa của một ngày trong tuần.
 */
public record BranchHoursResponse(
        String id,
        UUID branchId,
        Integer dayOfWeek,
        String dayName,
        LocalTime openTime,
        LocalTime closeTime,
        boolean isClosed,
        boolean isOvernight,
        String status
) {
}
