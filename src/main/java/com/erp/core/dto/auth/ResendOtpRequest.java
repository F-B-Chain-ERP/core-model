package com.erp.core.dto.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * Yêu cầu gửi lại mã OTP xác thực email, sử dụng token phiên đăng ký hiện tại.
 */
public record ResendOtpRequest(
        @NotBlank(message = "Verification token must not be blank")
        String verifyToken
) {
}
