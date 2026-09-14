package com.erp.core.dto.request.pos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record AddCartItemRequest(
    @NotNull UUID branchId,
    @Size(max = 150) String sessionToken,
    @NotNull UUID productId,
    UUID variantId,
    @NotNull @Min(1) Integer quantity,
    @Size(max = 30) String iceLevel,
    @Size(max = 30) String sugarLevel,
    @Size(max = 255) String note,
    @Valid List<ToppingRequest> toppings
) {
    public record ToppingRequest(@NotNull UUID toppingId, @NotNull @Min(1) Integer quantity) {
    }
}
