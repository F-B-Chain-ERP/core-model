package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AddComboItemRequest(

        @NotNull(message = "Biến thể không được để trống")
        UUID variantId,

        @Min(value = 1, message = "Số lượng phải >= 1")
        Integer quantity,

        Boolean isSubstitutable
) {
    public AddComboItemRequest {
        if (quantity == null) quantity = 1;
        if (isSubstitutable == null) isSubstitutable = false;
    }
}
