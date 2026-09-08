package com.erp.core.dto.request.inv;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CreateStockCountRequest(
        @Size(max = 50) String code,
        @NotNull UUID warehouseId,
        @NotNull LocalDate countDate,
        @Size(max = 500) String note,
        @NotEmpty List<@Valid StockCountItemRequest> items
) {}
