package com.erp.core.dto.request.menu;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * DTO yêu cầu đồng bộ toàn bộ danh sách biến thể của sản phẩm (thêm mới, cập nhật, xóa các mục bị bỏ).
 */
public record SyncProductVariantsRequest(
        @Valid
        @NotNull(message = "Danh sách biến thể không được null")
        List<VariantItemRequest> variants
) {

    public record VariantItemRequest(
            /** ID biến thể nếu đã tồn tại, để null nếu tạo mới */
            UUID id,

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
        public VariantItemRequest {
            if (displayOrder == null) {
                displayOrder = 0;
            }
            if (priceDelta == null) {
                priceDelta = BigDecimal.ZERO;
            }
            if (status == null || status.isBlank()) {
                status = "ACTIVE";
            }
        }
    }
}
