package com.erp.core.dto.response.pos;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record OrderSummaryResponse(UUID id, String orderCode, UUID branchId, String orderType,
                                   String receiverName, BigDecimal totalAmount, String status, Instant createdAt,
                                   String paymentMethod, String paymentStatus) {
    public OrderSummaryResponse(UUID id, String orderCode, UUID branchId, String orderType,
                                String receiverName, BigDecimal totalAmount, String status, Instant createdAt) {
        this(id, orderCode, branchId, orderType, receiverName, totalAmount, status, createdAt, null, null);
    }
}
