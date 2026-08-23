package com.erp.core.dto.request.proc;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Yêu cầu tạo mới nhà cung cấp. Mã và tên là bắt buộc, các trường còn lại tùy chọn
 * và sẽ dùng giá trị mặc định của thực thể nếu không được cung cấp.
 */
public record CreateSupplierRequest(
        @NotBlank(message = "Mã nhà cung cấp không được để trống")
        @Size(max = 50, message = "Mã nhà cung cấp tối đa 50 ký tự")
        String code,

        @NotBlank(message = "Tên nhà cung cấp không được để trống")
        @Size(max = 200, message = "Tên nhà cung cấp tối đa 200 ký tự")
        String name,

        @Size(max = 30, message = "Mã số thuế tối đa 30 ký tự")
        String taxCode,

        @Size(max = 150, message = "Tên người liên hệ tối đa 150 ký tự")
        String contactName,

        @Size(max = 20, message = "Số điện thoại tối đa 20 ký tự")
        String phone,

        @Size(max = 150, message = "Email tối đa 150 ký tự")
        String email,

        @Size(max = 255, message = "Địa chỉ tối đa 255 ký tự")
        String address,

        Integer paymentTermDays,

        @Size(max = 30, message = "Trạng thái tối đa 30 ký tự")
        String status
) {
}
