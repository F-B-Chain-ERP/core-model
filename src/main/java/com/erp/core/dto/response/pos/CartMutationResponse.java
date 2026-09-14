package com.erp.core.dto.response.pos;

import java.math.BigDecimal;
import java.util.UUID;

public record CartMutationResponse(UUID cartId, UUID cartDetailId, Integer quantity, BigDecimal totalPrice,
                                   BigDecimal subtotalAmount) {
}
