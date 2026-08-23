package com.erp.core.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Yêu cầu đặt lại mật khẩu bằng mã OTP: mang theo reset token (phiên quên mật khẩu),
 * mã OTP và mật khẩu mới.
 */
public record ResetPasswordOtpRequest(
        @NotBlank(message = "Reset token must not be blank")
        String resetToken,

        @NotBlank(message = "OTP must not be blank")
        String otp,

        @NotBlank(message = "New password must not be blank")
        @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
        String newPassword
) {
}
