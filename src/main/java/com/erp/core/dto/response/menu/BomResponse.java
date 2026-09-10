package com.erp.core.dto.response.menu;

import java.util.List;

/**
 * DTO response cho endpoint GET BOM của một_variant.
 * Chứa thông tin variant và danh sách các dòng BOM.
 * Nếu_variant chưa có BOM thì {@code items} là danh sách rỗng.
 */
public record BomResponse(
        /** ID_variant (UUID dạng chuỗi). */
        String variantId,

        /** Tên_variant. */
        String variantName,

        /** Danh sách dòng BOM. */
        List<BomItemResponse> items
) {
}
