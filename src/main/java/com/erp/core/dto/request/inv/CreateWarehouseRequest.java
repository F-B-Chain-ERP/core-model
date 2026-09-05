package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record CreateWarehouseRequest(

        @NotBlank(message = "Code is required")
        @Size(max = 50, message = "Code max 50 characters")
        String code,

        @NotBlank(message = "Name is required")
        @Size(max = 150, message = "Name max 150 characters")
        String name,

        @NotBlank(message = "Warehouse type is required")
        String warehouseType,

        UUID branchId,

        @Size(max = 255, message = "Address max 255 characters")
        String address
) {
}
