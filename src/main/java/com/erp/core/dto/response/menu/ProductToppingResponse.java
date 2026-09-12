package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

public record ProductToppingResponse(
        String id,
        String productId,
        String toppingId,
        String toppingCode,
        String toppingName,
        BigDecimal toppingPrice,
        String groupName,
        boolean isDefault,
        int maxQuantity,
        String status
) {
}
