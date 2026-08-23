package com.erp.core.dto.auth;

import com.erp.core.enums.AuthProvider;
import com.erp.core.enums.EntityStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * Yêu cầu tạo tài khoản khách hàng (customer) bởi admin nội bộ. Khác với đăng ký
 * tự do, admin có thể cấp thông tin và mật khẩu sẵn; mật khẩu không bắt buộc
 * (nếu không truyền, khách hàng chưa có mật khẩu local và cần đặt lại sau).
 */
public record CreateCustomerRequest(
        @NotBlank(message = "Full name must not be blank")
        @Size(max = 150, message = "Full name must not exceed 150 characters")
        String fullName,

        @Size(min = 3, max = 100, message = "Username must be between 3 and 100 characters")
        String username,

        @Pattern(regexp = "^[0-9+\\-\\s]{8,20}$", message = "Phone is invalid")
        String phone,

        @Email(message = "Email is invalid")
        String email,

        @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
        String password,

        @Size(max = 500, message = "Avatar URL must not exceed 500 characters")
        String avatarUrl,

        LocalDate dateOfBirth,

        String gender,

        Boolean emailVerified,

        EntityStatus status,

        AuthProvider authProvider
) {
}
