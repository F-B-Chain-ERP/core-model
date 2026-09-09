package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

/**
 * DTO đại diện cho một kích cỡ / phiên bản của sản phẩm (Size S, M, L...).
 */
public record ProductVariantResponse(
        /** ID của phiên bản (UUID chuỗi). */
        String id,

        /** Mã phiên bản (ví dụ: S, M, L, CF-PHIN-SUA-S). */
        String variantCode,

        /** Tên phiên bản hiển thị (ví dụ: Size S, Size M). */
        String variantName,

        /** Nhãn kích cỡ ngắn gọn (S, M, L...). */
        String sizeLabel,

        /** Số tiền chênh lệch so với giá cơ bản của sản phẩm. */
        BigDecimal priceDelta,

        /** Thứ tự sắp xếp hiển thị. */
        int displayOrder,

        /** Trạng thái kích cỡ (ACTIVE, INACTIVE...). */
        String status
) {
}
