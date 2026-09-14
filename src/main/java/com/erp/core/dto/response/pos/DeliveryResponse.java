package com.erp.core.dto.response.pos;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record DeliveryResponse(UUID id, UUID orderId, UUID shipperId, String receiverName,
                               String receiverPhone, String deliveryAddress, String deliveryNote,
                               BigDecimal deliveryFee, String status, Instant assignedAt,
                               Instant pickedUpAt, Instant deliveredAt, Instant failedAt,
                               String failReason) {
}
