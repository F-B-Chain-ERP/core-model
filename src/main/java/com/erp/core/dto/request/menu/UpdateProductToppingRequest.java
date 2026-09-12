package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.Min;

public record UpdateProductToppingRequest(

        Boolean isDefault,

        @Min(value = 1, message = "Số lượng tối đa phải >= 1")
        Integer maxQuantity
) {
    public UpdateProductToppingRequest {
        if (isDefault == null) isDefault = false;
        if (maxQuantity == null) maxQuantity = 1;
    }
}
