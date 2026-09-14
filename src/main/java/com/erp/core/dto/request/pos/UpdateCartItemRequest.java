package com.erp.core.dto.request.pos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record UpdateCartItemRequest(
    @Min(1) Integer quantity,
    @Size(max = 30) String iceLevel,
    @Size(max = 30) String sugarLevel,
    @Size(max = 255) String note
) {
}
