package com.erp.core.dto.request.pos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record KdsTicketStatusRequest(
    @Size(max = 500) String note
) {}
