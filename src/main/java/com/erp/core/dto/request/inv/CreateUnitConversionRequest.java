package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/** Tạo 1 chiều quy đổi giữa 2 đơn vị cùng nhóm (chiều ngược tự đảo 1/factor). */
public record CreateUnitConversionRequest(

        @NotNull(message = "Đơn vị nguồn không được để trống")
        UUID fromUnitId,

        @NotNull(message = "Đơn vị đích không được để trống")
        UUID toUnitId,

        @NotNull(message = "Hệ số quy đổi không được để trống")
        @DecimalMin(value = "0.0", inclusive = false, message = "Hệ số quy đổi phải lớn hơn 0")
        java.math.BigDecimal factor
) {
}
