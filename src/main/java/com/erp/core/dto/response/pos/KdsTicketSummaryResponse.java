package com.erp.core.dto.response.pos;

import java.time.Instant;
import java.util.UUID;

public record KdsTicketSummaryResponse(
    UUID id,
    UUID orderId,
    String orderCode,
    String orderStatus,
    UUID branchId,
    String station,
    Integer queueNo,
    String ticketCode,
    String status,
    String customerName,
    String orderType,
    Integer totalItems,
    Instant createdAt
) {}
