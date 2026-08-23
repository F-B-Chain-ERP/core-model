package com.erp.core.dto.request.proc;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Một dòng chi tiết trong yêu cầu tạo/cập nhật đơn mua hàng.
 */
public record PurchaseOrderItemRequest(
        @NotNull(message = "Nguyên liệu không được để trống")
        UUID materialId,

        @NotNull(message = "Số lượng không được để trống")
        @Positive(message = "Số lượng phải > 0")
        BigDecimal quantity,

        @NotNull(message = "Đơn vị tính không được để trống")
        UUID unitId,

        @NotNull(message = "Đơn giá không được để trống")
        @PositiveOrZero(message = "Đơn giá phải >= 0")
        BigDecimal unitPrice
) {
}
