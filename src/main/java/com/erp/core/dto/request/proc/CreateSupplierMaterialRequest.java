package com.erp.core.dto.request.proc;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateSupplierMaterialRequest(

        @NotNull(message = "Mã nhà cung cấp không được để trống")
        UUID supplierId,

        @NotNull(message = "Mã nguyên vật liệu không được để trống")
        UUID materialId,

        String supplierSku,

        @NotNull(message = "Giá mua không được để trống")

        @DecimalMin(value = "0.0", inclusive = true, message = "Giá mua phải lớn hơn hoặc bằng 0")
        BigDecimal purchasePrice,

        @Min(value = 0, message = "Thời gian giao hàng phải lớn hơn hoặc bằng 0")
        Integer leadTimeDays,

        Boolean isPreferred,

        String status
) {
}
