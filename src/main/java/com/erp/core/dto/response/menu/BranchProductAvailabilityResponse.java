package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

public record BranchProductAvailabilityResponse(
        String id,
        String branchId,
        String productId,
        String productCode,
        String productName,
        BigDecimal basePrice,
        String categoryName,
        BigDecimal salePrice,
        boolean isAvailable,
        String status
) {
}
