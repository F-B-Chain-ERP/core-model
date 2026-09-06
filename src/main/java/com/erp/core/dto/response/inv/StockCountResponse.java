package com.erp.core.dto.response.inv;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record StockCountResponse(
        UUID id,
        String code,
        UUID warehouseId,
        String warehouseCode,
        String warehouseName,
        LocalDate countDate,
        String status,
        String note,
        List<StockCountItemResponse> items
) {}
