package com.erp.core.dto.response.inv;

import java.math.BigDecimal;
import java.util.UUID;

public record StockBalanceResponse(
        UUID id,
        UUID warehouseId,
        String warehouseCode,
        String warehouseName,
        UUID materialId,
        String materialCode,
        String materialName,
        BigDecimal quantityOnHand,
        BigDecimal quantityReserved,
        BigDecimal quantityAvailable,
        BigDecimal minStockAlert
) {}
