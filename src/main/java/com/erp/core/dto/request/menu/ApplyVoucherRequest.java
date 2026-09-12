package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Yêu cầu áp dụng voucher cho một đơn hàng (do Order/POS gọi vào service, chưa expose endpoint).
 */
public record ApplyVoucherRequest(

        @NotNull(message = "Mã voucher không được để trống")
        UUID voucherId,

        @NotNull(message = "Mã đơn hàng không được để trống")
        UUID orderId,

        UUID customerId,

        @NotNull(message = "Giá trị đơn hàng không được để trống")
        @DecimalMin(value = "0.0", message = "Giá trị đơn hàng phải lớn hơn hoặc bằng 0")
        BigDecimal orderAmount,

        @NotNull(message = "Mã chi nhánh không được để trống")
        UUID branchId
) {
}