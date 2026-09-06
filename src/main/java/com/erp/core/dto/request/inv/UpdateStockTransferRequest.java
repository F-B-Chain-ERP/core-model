package com.erp.core.dto.request.inv;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record UpdateStockTransferRequest(
        @NotNull UUID fromWarehouseId,
        @NotNull UUID toWarehouseId,
        @NotNull LocalDate transferDate,
        @Size(max = 500) String note,
        @NotEmpty List<@Valid StockTransferItemRequest> items
) {
    @AssertTrue(message = "Kho xuất và kho nhận phải khác nhau")
    public boolean isDifferentWarehouse() {
        return fromWarehouseId == null || toWarehouseId == null
                || !fromWarehouseId.equals(toWarehouseId);
    }
}
