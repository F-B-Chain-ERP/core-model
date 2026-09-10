package com.erp.core.dto.response.menu;

import java.math.BigDecimal;

/**
 * DTO response biểu diễn một dòng BOM (product_recipe_item).
 * Tên material và unitCode được resolve ở tầng Service để FE hiển thị trực tiếp.
 */
public record BomItemResponse(
        /** ID dòng BOM (UUID dạng chuỗi). */
        String id,

        /** ID nguyên vật liệu (UUID dạng chuỗi). */
        String materialId,

        /** Tên nguyên vật liệu (đã resolve từ materialId). */
        String materialName,

        /** Định lượng (DECIMAL(12,3)). */
        BigDecimal quantity,

        /** ID đơn vị tính (UUID dạng chuỗi). */
        String unitId,

        /** Mã đơn vị tính (đã resolve từ unitId). */
        String unitCode,

        /** Tỷ lệ hao hụt % (DECIMAL(5,2)). */
        BigDecimal wastagePercent
) {
}
