package com.erp.core.dto.auth;

import com.erp.core.enums.PrincipalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Yêu cầu gửi mã OTP đặt lại mật khẩu (quên mật khẩu) qua email.
 */
public record ForgotPasswordRequest(
        @NotBlank(message = "Email must not be blank")
        @Email(message = "Email is invalid")
        String email,

        PrincipalType type
) {
}
