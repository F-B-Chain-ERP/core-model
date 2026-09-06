package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateCategoryRequest(

        @NotBlank(message = "Loại danh mục không được để trống")
        @Pattern(
                regexp = "^(PRODUCT|MATERIAL)$",
                message = "Loại danh mục phải là PRODUCT hoặc MATERIAL"
        )
        String categoryType,

        @NotBlank(message = "Mã danh mục không được để trống")
        @Size(max = 50, message = "Mã danh mục tối đa 50 ký tự")
        @Pattern(
                regexp = "^[A-Z0-9_-]+$",
                message = "Mã danh mục chỉ gồm chữ hoa, số, dấu gạch ngang hoặc gạch dưới"
        )
        String code,

        @NotBlank(message = "Tên danh mục không được để trống")
        @Size(max = 150, message = "Tên danh mục tối đa 150 ký tự")
        String name,

        @Size(max = 255, message = "Mô tả tối đa 255 ký tự")
        String description,

        @Size(max = 500, message = "Đường dẫn ảnh tối đa 500 ký tự")
        @Pattern(
                regexp = "^(https?://.*)?$",
                message = "Đường dẫn ảnh không hợp lệ"
        )
        String imageUrl,

        @Min(value = 0, message = "Thứ tự hiển thị phải lớn hơn hoặc bằng 0")
        Integer displayOrder
) {
}
