package com.erp.core.dto.response.menu;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Read-side projection của {@code VoucherUsage}.
 */
public record VoucherUsageResponse(
        /** ID bản ghi sử dụng voucher (UUID dạng chuỗi). */
        String id,

        /** ID voucher (UUID dạng chuỗi). */
        String voucherId,

        /** ID đơn hàng đã dùng voucher (UUID dạng chuỗi). */
        String orderId,

        /** ID khách hàng sử dụng voucher, null nếu đơn không gắn khách. */
        String customerId,

        /** Số tiền giảm thực tế của đơn hàng. */
        BigDecimal discountAmount,

        /** Thời điểm voucher được áp dụng cho đơn hàng. */
        Instant usedAt,

        /** Trạng thái: ACTIVE hoặc INACTIVE. */
        String status,

        /** Người tạo bản ghi. */
        String createdBy,

        /** Thời điểm tạo. */
        Instant createdAt
) {
}