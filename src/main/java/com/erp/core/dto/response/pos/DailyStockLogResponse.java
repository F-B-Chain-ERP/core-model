package com.erp.core.dto.response.pos;

import java.time.Instant;
import java.util.UUID;

/**
 * Một vết biến động tồn POS: RESTOCK (chốt sáng), SALE (trừ lúc CONFIRMED),
 * ADJUSTMENT (hoàn lúc hủy). quantityChange âm = trừ, dương = cộng/hoàn.
 */
public record DailyStockLogResponse(
    UUID id,
    UUID variantId,
    String variantCode,
    String variantName,
    String changeType,
    Integer quantityChange,
    UUID referenceId,
    String note,
    Instant createdAt
) {}
