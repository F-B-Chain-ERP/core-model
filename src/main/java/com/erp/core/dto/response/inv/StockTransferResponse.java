package com.erp.core.dto.response.inv;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record StockTransferResponse(
        UUID id,
        String code,
        UUID fromWarehouseId,
        String fromWarehouseCode,
        String fromWarehouseName,
        UUID toWarehouseId,
        String toWarehouseCode,
        String toWarehouseName,
        LocalDate transferDate,
        String status,
        String note,
        UUID receivedBy,
        Instant receivedAt,
        List<StockTransferItemResponse> items
) {}
