package com.erp.core.dto.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * Yêu cầu xác thực mã OTP email: mang theo token phiên đăng ký (verifyToken)
 * và mã OTP 6 số do người dùng nhập.
 */
public record VerifyOtpRequest(
        @NotBlank(message = "Verification token must not be blank")
        String verifyToken,

        @NotBlank(message = "OTP must not be blank")
        String otp
) {
}
