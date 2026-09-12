package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

/**
 * DTO đại diện cho một dòng nguyên vật liệu trong công thức định lượng (BOM).
 */
public record ProductRecipeItemResponse(
        /** ID của dòng công thức (UUID chuỗi). */
        String id,

        /** ID của biến thể đồ uống. */
        String variantId,

        /** ID nguyên vật liệu. */
        String materialId,

        /** Tên nguyên vật liệu. */
        String materialName,

        /** Mã nguyên vật liệu. */
        String materialCode,

        /** Định lượng tiêu hao chuẩn cho 1 đơn vị biến thể. */
        BigDecimal quantity,

        /** ID đơn vị tính. */
        String unitId,

        /** Mã/Ký hiệu đơn vị tính (ML, G, CÁI...). */
        String unitCode,

        /** Tỷ lệ hao hụt định mức (phần trăm: 0 - 100). */
        BigDecimal wastagePercent,

        /** Trạng thái dòng định lượng (ACTIVE, INACTIVE). */
        String status
) {
}
