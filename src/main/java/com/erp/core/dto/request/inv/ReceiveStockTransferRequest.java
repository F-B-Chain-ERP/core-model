package com.erp.core.dto.request.inv;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record ReceiveStockTransferRequest(
        @NotEmpty List<@Valid ReceiveStockTransferItemRequest> items
) {}
