package com.erp.core.dto.request.menu;

import java.math.BigDecimal;

/**
 * DTO yêu cầu cập nhật một dòng BOM hiện có.
 * Chỉ cho phép thay đổi {@code quantity} và {@code wastagePercent}.
 * Không thay đổi materialId, variantId, unitId qua endpoint này.
 */
public record UpdateBomItemRequest(
        BigDecimal quantity,
        BigDecimal wastagePercent
) {
}
