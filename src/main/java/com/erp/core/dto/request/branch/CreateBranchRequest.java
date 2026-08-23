package com.erp.core.dto.request.branch;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Yêu cầu tạo mới chi nhánh. Các trường tọa độ, liên hệ và cấu hình là tùy chọn,
 * sẽ dùng giá trị mặc định của thực thể nếu không được cung cấp.
 */
public record CreateBranchRequest(
        @NotBlank(message = "Mã chi nhánh không được để trống")
        @Size(max = 50, message = "Mã chi nhánh tối đa 50 ký tự")
        String code,

        @NotBlank(message = "Tên chi nhánh không được để trống")
        @Size(max = 150, message = "Tên chi nhánh tối đa 150 ký tự")
        String name,

        @Size(max = 255, message = "Địa chỉ tối đa 255 ký tự")
        String address,

        @Size(max = 20, message = "Số điện thoại tối đa 20 ký tự")
        String phone,

        @Size(max = 150, message = "Email tối đa 150 ký tự")
        String email,

        BigDecimal latitude,

        BigDecimal longitude,

        @Size(max = 50, message = "Múi giờ tối đa 50 ký tự")
        String timezone,

        Boolean supportsPickup,

        Boolean supportsDelivery,

        @PositiveOrZero(message = "Thời gian chuẩn bị phải >= 0")
        Integer averagePreparationMinutes,

        @Size(max = 30, message = "Trạng thái tối đa 30 ký tự")
        String status,

        UUID parentId
) {
}
