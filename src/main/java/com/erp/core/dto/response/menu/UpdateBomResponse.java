package com.erp.core.dto.response.menu;

/**
 * DTO response cho endpoint PUT bulk-replace BOM.
 * Trả về_variant ID và số lượng dòng BOM sau khi thay thế.
 */
public record UpdateBomResponse(
        /** ID_variant (UUID dạng chuỗi). */
        String variantId,

        /** Số lượng dòng BOM sau khi thay thế. */
        int itemCount
) {
}
