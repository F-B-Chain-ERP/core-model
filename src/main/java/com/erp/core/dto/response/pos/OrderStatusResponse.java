package com.erp.core.dto.response.pos;

import java.time.Instant;
import java.util.UUID;

public record OrderStatusResponse(UUID orderId, String orderCode, String previousStatus,
                                  String currentStatus, UUID updatedBy, Instant updatedAt) {
}
