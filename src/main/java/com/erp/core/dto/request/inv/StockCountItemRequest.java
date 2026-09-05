package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record StockCountItemRequest(
        @NotNull UUID materialId,
        @DecimalMin(value = "0.0")
        @Digits(integer = 11, fraction = 3)
        BigDecimal countedQuantity,
        @Size(max = 255) String note
) {
}
