package com.erp.core.dto.response.pos;

import java.time.Instant;
import java.util.UUID;

public record OrderHistoryResponse(UUID id, UUID orderId, String oldStatus, String newStatus,
                                   UUID changedBy, Instant changedAt, String note) {
}
