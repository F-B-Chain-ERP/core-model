package com.erp.core.dto.request.pos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CancelOrderRequest(
    @NotBlank @Size(max = 255) String reason, @Size(max = 500) String note
) {
}
