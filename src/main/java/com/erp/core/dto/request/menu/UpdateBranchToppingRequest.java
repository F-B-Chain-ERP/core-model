package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.NotNull;

public record UpdateBranchToppingRequest(

        @NotNull(message = "Trạng thái khả dụng không được để trống")
        Boolean isAvailable
) {
}
