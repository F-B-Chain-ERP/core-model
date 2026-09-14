package com.erp.core.dto.request.pos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateOrderStatusRequest(
    @NotBlank String status,
    @Size(max = 500) String note
) {}
