package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO yêu cầu cập nhật thông tin sản phẩm thực đơn (Master Data).
 */
public record UpdateProductRequest(

        @NotNull(message = "Danh mục không được để trống")
        UUID categoryId,

        @NotBlank(message = "Mã sản phẩm không được để trống")
        @Size(max = 50, message = "Mã sản phẩm tối đa 50 ký tự")
        @Pattern(
                regexp = "^[A-Za-z0-9_-]+$",
                message = "Mã sản phẩm chỉ gồm chữ cái, số, dấu gạch ngang hoặc gạch dưới"
        )
        String code,

        @NotBlank(message = "Tên sản phẩm không được để trống")
        @Size(max = 150, message = "Tên sản phẩm tối đa 150 ký tự")
        String name,

        @Size(max = 500, message = "Mô tả tối đa 500 ký tự")
        String description,

        /** URL ảnh sản phẩm */
        @Size(max = 500, message = "Đường dẫn ảnh tối đa 500 ký tự")
        String imageUrl,

        @NotNull(message = "Đơn giá cơ bản không được để trống")
        @DecimalMin(value = "0", message = "Đơn giá phải lớn hơn hoặc bằng 0")
        BigDecimal basePrice,

        @Min(value = 0, message = "Thời gian chuẩn bị phải lớn hơn hoặc bằng 0")
        Integer preparationMinutes,

        Boolean isFeatured,

        Boolean isBestSeller,

        Boolean isCombo,

        @Size(max = 50, message = "Mức đá tối đa 50 ký tự")
        String availableIceLevels,

        @Size(max = 50, message = "Mức đường tối đa 50 ký tự")
        String availableSugarLevels,

        @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Trạng thái phải là ACTIVE hoặc INACTIVE")
        String status
) {
}
