package com.erp.core.dto.request.proc;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Một dòng ghi nhận thực nhận, ánh xạ tới {@code purchase_order_item} theo id.
 */
public record ReceivePurchaseOrderItemRequest(
        @NotNull(message = "Dòng đơn mua hàng không được để trống")
        UUID purchaseOrderItemId,

        @NotNull(message = "Số lượng nhận không được để trống")
        @Positive(message = "Số lượng nhận phải > 0")
        BigDecimal receivedQuantity
) {
}
