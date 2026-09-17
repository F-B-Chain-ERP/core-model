package com.erp.core.dto.request.pos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RestockDailyStockRequest(
    @NotNull UUID branchId,
    @NotNull UUID variantId,
    @NotNull @Min(0) Integer openingQuantity,
    String note
) {
}
