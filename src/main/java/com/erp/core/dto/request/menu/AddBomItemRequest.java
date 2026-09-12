package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Yêu cầu thêm nguyên vật liệu vào công thức định lượng (BOM) của biến thể.
 */
public record AddBomItemRequest(
        @NotNull(message = "Nguyên vật liệu không được để trống")
        UUID materialId,

        @NotNull(message = "Số lượng định mức không được để trống")
        @DecimalMin(value = "0.001", message = "Số lượng định mức phải lớn hơn 0")
        BigDecimal quantity,

        @NotNull(message = "Đơn vị tính không được để trống")
        UUID unitId,

        @DecimalMin(value = "0.0", message = "Tỷ lệ hao hụt không được nhỏ hơn 0%")
        @DecimalMax(value = "100.0", message = "Tỷ lệ hao hụt không được vượt quá 100%")
        BigDecimal wastagePercent
) {
}
