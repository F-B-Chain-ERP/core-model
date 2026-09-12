package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateToppingRequest(

        @NotBlank(message = "Mã topping không được để trống")
        @Size(max = 50, message = "Mã topping tối đa 50 ký tự")
        @Pattern(regexp = "^[A-Za-z0-9_-]+$", message = "Mã topping chỉ gồm chữ cái, số, dấu gạch ngang hoặc gạch dưới")
        String code,

        @NotBlank(message = "Tên topping không được để trống")
        @Size(max = 150, message = "Tên topping tối đa 150 ký tự")
        String name,

        @NotNull(message = "Đơn giá không được để trống")
        @DecimalMin(value = "0", message = "Đơn giá phải lớn hơn hoặc bằng 0")
        BigDecimal price,

        @Size(max = 500, message = "Đường dẫn ảnh tối đa 500 ký tự")
        String imageUrl,

        @Size(max = 100, message = "Tên nhóm topping tối đa 100 ký tự")
        String groupName,

        UUID materialId,

        @DecimalMin(value = "0.001", message = "Số lượng nguyên vật liệu phải lớn hơn 0")
        BigDecimal materialQuantity
) {
}
