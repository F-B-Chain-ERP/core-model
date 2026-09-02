package com.erp.core.dto.request.proc;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateSupplierRequest(

        @NotBlank(message = "Mã nhà cung cấp không được để trống")
        @Size(max = 50, message = "Mã nhà cung cấp tối đa 50 ký tự")
        @Pattern(
                regexp = "^[A-Z0-9_-]+$",
                message = "Mã nhà cung cấp chỉ gồm chữ hoa, số, dấu gạch ngang hoặc gạch dưới"
        )
        String code,

        @NotBlank(message = "Tên nhà cung cấp không được để trống")
        @Size(max = 200, message = "Tên nhà cung cấp tối đa 200 ký tự")
        String name,

        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "Mã số thuế phải là 10 hoặc 13 chữ số"
        )
        String taxCode,

        @Size(max = 150, message = "Tên người liên hệ tối đa 150 ký tự")
        String contactName,

        @NotBlank(message = "Số điện thoại không được để trống")
        @Pattern(
                regexp = "^[0-9]{10}$",
                message = "Số điện thoại phải gồm 10 chữ số"
        )
        String phone,

        @Email(message = "Email không đúng định dạng")
        @Size(max = 150, message = "Email tối đa 150 ký tự")
        String email,

        @Size(max = 255, message = "Địa chỉ tối đa 255 ký tự")
        String address,

        @NotNull(message = "Hạn nợ thanh toán không được để trống")
        @Min(value = 0, message = "Hạn nợ phải lớn hơn hoặc bằng 0")
        Integer paymentTermDays,

        @Size(max = 30, message = "Trạng thái tối đa 30 ký tự")
        String status
) {
}