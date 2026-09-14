package com.erp.core.dto.response.pos;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CartItemResponse(UUID cartDetailId, UUID productId, String productCode, String productName,
                               UUID variantId, String variantName, Integer quantity, String iceLevel,
                               String sugarLevel, String note, BigDecimal unitPrice, BigDecimal totalPrice,
                               List<CartItemToppingResponse> toppings) {
}
