package com.erp.core.dto.response.menu;

import java.math.BigDecimal;
import java.util.List;

public record ComboDetailResponse(
        String comboProductId,
        String code,
        String name,
        BigDecimal basePrice,
        boolean isCombo,
        String status,
        List<ComboItemResponse> items
) {
}
