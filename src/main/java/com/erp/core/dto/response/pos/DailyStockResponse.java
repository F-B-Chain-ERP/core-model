package com.erp.core.dto.response.pos;

import java.time.LocalDate;
import java.util.UUID;

public record DailyStockResponse(UUID branchId, UUID variantId, LocalDate businessDate, Integer openingQuantity,
                                 Integer remainingQuantity, Integer soldQuantity) {
}
