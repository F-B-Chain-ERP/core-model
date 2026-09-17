package com.erp.core.dto.response.branch;

import java.time.LocalTime;
import java.util.UUID;

/**
 * Phản hồi thông tin khung giờ nhận món tại quán (Pickup Time Slot).
 */
public record PickupTimeSlotResponse(
        String id,
        UUID branchId,
        String slotCode,
        LocalTime startTime,
        LocalTime endTime,
        Integer maxOrders,
        long currentOrders,
        boolean isAvailable,
        String status
) {
}
