package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AddProductToppingRequest(

        @NotNull(message = "Topping không được để trống")
        UUID toppingId,

        Boolean isDefault,

        @Min(value = 1, message = "Số lượng tối đa phải >= 1")
        Integer maxQuantity
) {
    public AddProductToppingRequest {
        if (isDefault == null) isDefault = false;
        if (maxQuantity == null) maxQuantity = 1;
    }
}
