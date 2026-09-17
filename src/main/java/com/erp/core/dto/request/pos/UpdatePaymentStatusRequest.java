package com.erp.core.dto.request.pos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdatePaymentStatusRequest(
    @NotBlank @Pattern(regexp = "UNPAID|PAID|REFUNDED") String status,
    @Size(max = 500) String note
) {
}
