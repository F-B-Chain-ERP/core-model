package com.erp.core.dto.request.proc;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

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
        @Digits(integer = 11, fraction = 3, message = "Số lượng tối đa 11 số nguyên và 3 số lẻ")
        BigDecimal quantity,

        @NotNull(message = "Đơn vị tính không được để trống")
        UUID unitId,

        @NotNull(message = "Đơn giá không được để trống")
        @Positive(message = "Đơn giá phải > 0")
        @Digits(integer = 10, fraction = 2, message = "Đơn giá tối đa 10 số nguyên và 2 số lẻ")
        BigDecimal unitPrice
) {
}
