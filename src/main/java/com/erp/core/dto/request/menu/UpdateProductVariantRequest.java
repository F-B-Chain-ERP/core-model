package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * DTO yêu cầu cập nhật thông tin biến thể / kích cỡ sản phẩm.
 */
public record UpdateProductVariantRequest(

        @NotBlank(message = "Mã biến thể không được để trống")
        @Size(max = 50, message = "Mã biến thể tối đa 50 ký tự")
        String variantCode,

        @NotBlank(message = "Tên biến thể không được để trống")
        @Size(max = 100, message = "Tên biến thể tối đa 100 ký tự")
        String variantName,

        @NotBlank(message = "Nhãn kích cỡ không được để trống")
        @Size(max = 30, message = "Nhãn kích cỡ tối đa 30 ký tự")
        String sizeLabel,

        @NotNull(message = "Độ lệch giá không được để trống")
        BigDecimal priceDelta,

        @Min(value = 0, message = "Thứ tự hiển thị phải lớn hơn hoặc bằng 0")
        Integer displayOrder,

        @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Trạng thái phải là ACTIVE hoặc INACTIVE")
        String status
) {
    public UpdateProductVariantRequest {
        if (displayOrder == null) {
            displayOrder = 0;
        }
        if (priceDelta == null) {
            priceDelta = BigDecimal.ZERO;
        }
    }
}
