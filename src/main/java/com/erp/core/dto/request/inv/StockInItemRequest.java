package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Một dòng chi tiết trong phiếu nhập kho. {@code purchaseOrderItemId} là bắt buộc khi
 * nguồn nhập là PURCHASE (liên kết dòng đơn mua hàng), ngược lại để trống.
 */
public record StockInItemRequest(
        UUID purchaseOrderItemId,

        @NotNull(message = "Nguyên liệu không được để trống")
        UUID materialId,

        @NotNull(message = "Số lượng không được để trống")
        @Positive(message = "Số lượng phải lớn hơn 0")
        BigDecimal quantity,

        @PositiveOrZero(message = "Đơn giá không được âm")
        BigDecimal unitPrice,

        @Size(max = 80, message = "Mã lô không được vượt quá 80 ký tự")
        String batchNo,

        LocalDate expiryDate
) {
}