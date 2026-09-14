package com.erp.core.dto.request.pos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AssignDeliveryRequest(
    @NotNull UUID shipperId
) {
}
