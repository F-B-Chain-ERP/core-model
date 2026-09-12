package com.erp.core.dto.request.menu;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu cập nhật / đồng bộ toàn bộ công thức định lượng (BOM) của một biến thể.
 */
public record BulkSyncBomRequest(
        @NotNull(message = "Danh sách nguyên vật liệu không được để trống")
        @Valid
        List<SyncBomItemEntry> items
) {
    public record SyncBomItemEntry(
            /** ID dòng công thức cũ (nếu có để nhận diện). */
            UUID id,

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
}
