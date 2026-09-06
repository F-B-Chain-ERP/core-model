package com.erp.core.dto.request.inv;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateWarehouseRequest(

        @NotBlank(message = "Mã kho không được để trống")
        @Size(max = 50, message = "Mã kho tối đa 50 ký tự")
        @Pattern(
                regexp = "^[A-Z0-9_-]+$",
                message = "Mã kho chỉ gồm chữ hoa, số, dấu gạch ngang hoặc gạch dưới"
        )
        String code,

        @NotBlank(message = "Tên kho không được để trống")
        @Size(max = 150, message = "Tên kho tối đa 150 ký tự")
        String name,

        @NotBlank(message = "Loại kho không được để trống")
        @Pattern(
                regexp = "^(BRANCH|CENTRAL|VIRTUAL)$",
                message = "Loại kho phải là BRANCH, CENTRAL hoặc VIRTUAL"
        )
        String warehouseType,

        UUID branchId,

        @Size(max = 255, message = "Địa chỉ tối đa 255 ký tự")
        String address,

        String status
) {
}
