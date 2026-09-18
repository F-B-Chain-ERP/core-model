package com.erp.core.dto.response.pos;

import java.time.Instant;
import java.util.UUID;

public record KdsTicketItemResponse(
    UUID id,
    UUID kdsTicketId,
    UUID orderItemId,
    String productCode,
    String productName,
    String variantName,
    Integer quantity,
    String sugarLevel,
    String iceLevel,
    String note,
    Integer preparedQuantity,
    String status,
    Instant createdAt
) {}
