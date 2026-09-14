package com.erp.core.dto.response.pos;

import java.time.Instant;
import java.util.UUID;

public record DeliveryStatusResponse(UUID deliveryId, UUID orderId, String previousStatus,
                                     String currentStatus, Instant updatedAt) {
}
