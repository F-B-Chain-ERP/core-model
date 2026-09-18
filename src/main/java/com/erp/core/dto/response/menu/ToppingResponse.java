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
        String materialName,
        BigDecimal materialQuantity,
        String status,
        String createdBy,
        Instant createdAt,
        Instant updatedAt
) {
}
