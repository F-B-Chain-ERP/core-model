package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Một dòng chi tiết trong phiếu xuất kho.
 */
public record StockOutItemRequest(
        @NotNull(message = "Nguyên liệu không được để trống")
        UUID materialId,

        @NotNull(message = "Số lượng không được để trống")
        @Positive(message = "Số lượng phải lớn hơn 0")
        BigDecimal quantity,

        @PositiveOrZero(message = "Đơn giá không được âm")
        BigDecimal unitPrice,

        @Size(max = 80, message = "Mã lô không được vượt quá 80 ký tự")
        String batchNo
) {
}