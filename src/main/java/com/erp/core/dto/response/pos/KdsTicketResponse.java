package com.erp.core.dto.response.pos;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record KdsTicketResponse(
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
    String customerPhone,
    String orderType,
    String note,
    Instant startedAt,
    Instant readyAt,
    Instant servedAt,
    Instant createdAt,
    List<KdsTicketItemResponse> items
) {}
