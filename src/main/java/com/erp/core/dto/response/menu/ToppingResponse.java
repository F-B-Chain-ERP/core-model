package com.erp.core.dto.response.menu;

import java.math.BigDecimal;
import java.time.Instant;

public record ToppingResponse(
        String id,
        String code,
        String name,
        BigDecimal price,
        String imageUrl,
        String groupName,
        String materialId,
        BigDecimal materialQuantity,
        String status,
        Instant createdAt,
        Instant updatedAt
) {
}
