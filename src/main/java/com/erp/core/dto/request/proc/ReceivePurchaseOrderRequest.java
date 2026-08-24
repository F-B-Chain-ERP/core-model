package com.erp.core.dto.request.proc;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu ghi nhận số lượng thực nhận từ phân hệ Kho (INV) theo từng dòng đơn mua hàng.
 * Số lượng trong mỗi dòng là lượng nhận thêm vào lần này (không phải tổng lũy kế).
 */
public record ReceivePurchaseOrderRequest(
        @NotEmpty(message = "Vui lòng cung cấp ít nhất một dòng hàng đã nhận")
        List<ReceivePurchaseOrderItemRequest> items
) {
}
