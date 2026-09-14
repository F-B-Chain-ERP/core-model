package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateBranchProductRequest(

        @NotNull(message = "Trạng thái khả dụng không được để trống")
        Boolean isAvailable,

        @DecimalMin(value = "0", message = "Giá bán phải lớn hơn hoặc bằng 0")
        BigDecimal salePrice,

        Boolean clearPrice
) {
    public UpdateBranchProductRequest {
        if (clearPrice == null) clearPrice = false;
    }
}
