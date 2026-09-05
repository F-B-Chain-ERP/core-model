package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUnitRequest(

        @NotBlank(message = "Mã đơn vị tính không được để trống")
        @Size(max = 20, message = "Mã đơn vị tính tối đa 20 ký tự")
        @Pattern(
                regexp = "^[A-Z0-9_-]+$",
                message = "Mã đơn vị tính chỉ gồm chữ hoa, số, dấu gạch ngang hoặc gạch dưới"
        )
        String code,

        @NotBlank(message = "Tên đơn vị tính không được để trống")
        @Size(max = 50, message = "Tên đơn vị tính tối đa 50 ký tự")
        String name,

        @NotBlank(message = "Nhóm đơn vị tính không được để trống")
        @Pattern(
                regexp = "^(COUNT|WEIGHT|VOLUME)$",
                message = "Nhóm đơn vị tính phải là COUNT, WEIGHT hoặc VOLUME"
        )
        String unitType
) {
}
