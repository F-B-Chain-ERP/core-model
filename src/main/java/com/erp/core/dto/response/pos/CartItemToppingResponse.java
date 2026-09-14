package com.erp.core.dto.response.pos;

import java.math.BigDecimal;
import java.util.UUID;

public record CartItemToppingResponse(UUID toppingId, String toppingName, Integer quantity,
                                      BigDecimal unitPrice, BigDecimal totalPrice) {
}
