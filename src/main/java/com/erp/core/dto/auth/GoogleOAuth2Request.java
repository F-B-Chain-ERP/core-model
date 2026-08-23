package com.erp.core.dto.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * Yêu cầu xác thực khách hàng bằng Google OAuth2.
 * Phía client thực hiện Google Sign-In và gửi {@code idToken} (JWT credential)
 * về backend để xác minh và cấp token ứng dụng.
 */
public record GoogleOAuth2Request(
        @NotBlank(message = "Google id token must not be blank")
        String idToken
) {
}
