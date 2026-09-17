package com.erp.core.dto.response.pos;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OrderResponse(UUID id, String orderCode, UUID branchId, UUID customerId,
                            String customerName, String customerPhone, String customerEmail,
                            String orderType, String status, String paymentMethod, String paymentStatus,
                            BigDecimal subtotal, BigDecimal discount, BigDecimal shippingFee,
                            BigDecimal totalAmount, BigDecimal totalCogs, String shippingAddress,
                            String note, Instant createdAt, List<OrderItemResponse> items,
                            DeliveryResponse delivery, UUID pickupTimeSlotId, String pickupSlotCode) {
}
