package com.erp.core.dto.auth;

import com.erp.core.enums.AuthProvider;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Yêu cầu đăng ký tài khoản khách hàng (customer). Khách hàng tự đăng ký;
 * tài khoản nội bộ (account) không dùng endpoint này mà do admin cấp.
 */
public record RegisterCustomerRequest(
        @NotBlank(message = "Full name must not be blank")
        @Size(max = 150, message = "Full name must not exceed 150 characters")
        String fullName,

        @Pattern(regexp = "^[0-9+\\-\\s]{8,20}$", message = "Phone is invalid")
        String phone,

        @Email(message = "Email is invalid")
        String email,

        @NotBlank(message = "Password must not be blank")
        @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
        String password,

        AuthProvider authProvider
) {
}
