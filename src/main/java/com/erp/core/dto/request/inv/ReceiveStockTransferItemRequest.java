package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

public record ReceiveStockTransferItemRequest(
        @NotNull UUID itemId,
        @NotNull
        @DecimalMin(value = "0.001")
        @Digits(integer = 11, fraction = 3)
        BigDecimal receivedQuantity
) {}
