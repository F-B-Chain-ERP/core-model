package com.erp.core.dto.request.menu;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO yêu cầu tạo một dòng BOM (product_recipe_item) mới trong một_variant.
 * <p>Validate nghiệp vụ (quantity scale, wastage range, material active, unit mismatch…)
 * được xử lý ở tầng Service — Jakarta Bean Validation không dùng cho business rule.</p>
 */
public record CreateBomItemRequest(
        UUID materialId,
        BigDecimal quantity,
        UUID unitId,
        BigDecimal wastagePercent
) {
}
