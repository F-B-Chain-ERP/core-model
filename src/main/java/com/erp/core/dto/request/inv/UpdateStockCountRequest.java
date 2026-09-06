package com.erp.core.dto.request.inv;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;

public record UpdateStockCountRequest(
        @Size(max = 500) String note,
        List<@Valid StockCountItemRequest> items
) {}
