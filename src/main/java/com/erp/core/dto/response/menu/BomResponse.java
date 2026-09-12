package com.erp.core.dto.response.menu;

import java.util.List;

/**
 * DTO đại diện cho toàn bộ công thức định lượng (BOM) của một biến thể đồ uống.
 */
public record BomResponse(
        /** ID biến thể đồ uống (UUID chuỗi). */
        String variantId,

        /** Tên hiển thị đầy đủ của biến thể (ví dụ: Phin Sữa Đá - Size M). */
        String variantName,

        /** Danh sách các dòng nguyên vật liệu cấu thành. */
        List<ProductRecipeItemResponse> items
) {
}
