package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

public record BranchToppingAvailabilityResponse(
        String id,
        String branchId,
        String toppingId,
        String toppingCode,
        String toppingName,
        BigDecimal toppingPrice,
        String groupName,
        boolean isAvailable,
        String status
) {
}
