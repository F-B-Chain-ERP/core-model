package com.erp.core.dto.request.pos;

import jakarta.validation.constraints.Size;

public record CompleteOrderRequest(
    @Size(max = 500) String note
) {
}
