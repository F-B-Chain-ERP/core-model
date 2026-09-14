package com.erp.core.dto.response.pos;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderItemResponse(UUID id, String productCode, String productName, UUID variantId,
                                String variantCode, String variantName, Integer quantity, String iceLevel, String sugarLevel,
                                String note, BigDecimal unitPrice, BigDecimal amount,
                                BigDecimal unitCogsAmount, List<OrderItemToppingResponse> toppings) {
}
