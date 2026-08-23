package com.erp.core.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Yêu cầu đổi mật khẩu của người dùng đang đăng nhập: cần mật khẩu cũ để xác thực.
 */
public record ChangePasswordRequest(
        @NotBlank(message = "Old password must not be blank")
        String oldPassword,

        @NotBlank(message = "New password must not be blank")
        @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
        String newPassword
) {
}
