package com.erp.core.dto.request.pos;

import jakarta.validation.constraints.Min;

public record KdsTicketItemProgressRequest(
    @Min(0) Integer preparedQuantity,
    String status
) {}
