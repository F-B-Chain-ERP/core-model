package com.erp.core.dto.response.inv;

import java.math.BigDecimal;
import java.util.UUID;

public record StockTransferItemResponse(
        UUID id,
        UUID materialId,
        String materialCode,
        String materialName,
        BigDecimal quantity,
        BigDecimal receivedQuantity,
        BigDecimal remainingQuantity,
        BigDecimal unitPrice
) {}
