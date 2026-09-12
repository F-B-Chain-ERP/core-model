package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

/**
 * Kết quả áp dụng voucher vào đơn hàng.
 */
public record VoucherApplyResponse(
        /** ID voucher đã được áp dụng (UUID dạng chuỗi). */
        String voucherId,

        /** ID đơn hàng được áp dụng voucher (UUID dạng chuỗi). */
        String orderId,

        /** Số tiền được giảm sau khi áp voucher. */
        BigDecimal discountAmount,

        /** Số tiền đơn hàng phải trả sau khi giảm (orderAmount - discountAmount). */
        BigDecimal finalAmount
) {
}