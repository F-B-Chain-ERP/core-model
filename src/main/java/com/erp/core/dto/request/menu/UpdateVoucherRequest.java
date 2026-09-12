package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * Yêu cầu cập nhật voucher. Tất cả trường đều bắt buộc (gửi đủ giá trị hiện tại
 * nếu không muốn thay đổi), dùng để kiểm tra trùng mã khi cập nhật.
 */
public record UpdateVoucherRequest(

        @NotBlank(message = "Mã voucher không được để trống")
        @Size(max = 80, message = "Mã voucher tối đa 80 ký tự")
        @Pattern(
                regexp = "^[A-Z0-9_-]+$",
                message = "Mã voucher chỉ gồm chữ hoa, số, dấu gạch ngang hoặc gạch dưới"
        )
        String code,

        @NotBlank(message = "Tên voucher không được để trống")
        @Size(max = 150, message = "Tên voucher tối đa 150 ký tự")
        String name,

        @Size(max = 500, message = "Mô tả tối đa 500 ký tự")
        String description,

        @NotBlank(message = "Loại giảm giá không được để trống")
        @Pattern(
                regexp = "^(PERCENT|FIXED)$",
                message = "Loại giảm giá chỉ được phép là PERCENT hoặc FIXED"
        )
        String discountType,

        @NotNull(message = "Giá trị giảm giá không được để trống")
        @DecimalMin(value = "0.0", message = "Giá trị giảm giá phải lớn hơn hoặc bằng 0")
        BigDecimal discountValue,

        @DecimalMin(value = "0.0", message = "Số tiền giảm tối đa phải lớn hơn hoặc bằng 0")
        BigDecimal maxDiscountAmount,

        @DecimalMin(value = "0.0", message = "Giá trị đơn hàng tối thiểu phải lớn hơn hoặc bằng 0")
        BigDecimal minOrderAmount,

        @Min(value = 0, message = "Giới hạn sử dụng phải lớn hơn hoặc bằng 0")
        Integer usageLimit,

        @Min(value = 0, message = "Giới hạn sử dụng mỗi khách phải lớn hơn hoặc bằng 0")
        Integer usageLimitPerCustomer,

        @NotNull(message = "Thời gian bắt đầu hiệu lực không được để trống")
        Instant startAt,

        @NotNull(message = "Thời gian kết thúc hiệu lực không được để trống")
        Instant endAt,

        @NotBlank(message = "Trạng thái không được để trống")
        @Pattern(
                regexp = "^(ACTIVE|INACTIVE)$",
                message = "Trạng thái chỉ được phép là ACTIVE hoặc INACTIVE"
        )
        String status
) {
}