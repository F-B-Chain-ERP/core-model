package com.erp.core.dto.response.menu;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Read-side projection của {@code Voucher}.
 */
public record VoucherResponse(
        /** ID voucher (UUID dạng chuỗi). */
        String id,

        /** Mã voucher (duy nhất, viết hoa). */
        String code,

        /** Tên voucher. */
        String name,

        /** Mô tả voucher. */
        String description,

        /** Loại giảm giá: PERCENT (giảm %) hoặc FIXED (giảm tiền). */
        String discountType,

        /** Giá trị giảm giá: % (PERCENT) hoặc số tiền (FIXED). */
        BigDecimal discountValue,

        /** Số tiền giảm tối đa (chỉ áp dụng với PERCENT), null nếu không giới hạn. */
        BigDecimal maxDiscountAmount,

        /** Giá trị đơn hàng tối thiểu để dùng voucher. */
        BigDecimal minOrderAmount,

        /** Giới hạn tổng số lần sử dụng, null nếu không giới hạn. */
        Integer usageLimit,

        /** Số lần voucher đã được sử dụng. */
        int usedCount,

        /** Giới hạn số lần mỗi khách hàng được dùng, null nếu không giới hạn. */
        Integer usageLimitPerCustomer,

        /** Thời điểm voucher bắt đầu hiệu lực. */
        Instant startAt,

        /** Thời điểm voucher hết hiệu lực. */
        Instant endAt,

        /** Trạng thái: ACTIVE hoặc INACTIVE. */
        String status,

        /** Người tạo bản ghi. */
        String createdBy,

        /** Thời điểm tạo. */
        Instant createdAt,

        /** Người cập nhật gần nhất. */
        String updatedBy,

        /** Thời điểm cập nhật gần nhất. */
        Instant updatedAt
) {
}