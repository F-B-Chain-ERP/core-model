package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

/** Cập nhật hệ số / trạng thái một chiều quy đổi (không đổi cặp đơn vị). */
public record UpdateUnitConversionRequest(

        @DecimalMin(value = "0.0", inclusive = false, message = "Hệ số quy đổi phải lớn hơn 0")
        BigDecimal factor,

        /** Trạng thái (ACTIVE/INACTIVE, null = giữ nguyên). */
        String status
) {
}
