package com.erp.core.dto.response.inv;

import java.math.BigDecimal;
import java.util.UUID;

public record StockCountItemResponse(
        UUID id,
        UUID materialId,
        String materialCode,
        String materialName,
        BigDecimal systemQuantity,
        BigDecimal countedQuantity,
        BigDecimal varianceQuantity,
        String note
) {}
