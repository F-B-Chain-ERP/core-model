package com.erp.core.dto.response.pos;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CartResponse(UUID cartId, UUID branchId, BigDecimal subtotalAmount, List<CartItemResponse> items) {
}
