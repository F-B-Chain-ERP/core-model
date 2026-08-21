package com.erp.core.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RefreshTokenRequest(
        @NotBlank(message = "Refresh token must not be blank")
        @Size(max = 4096, message = "Refresh token must not exceed 4096 characters")
        String refreshToken
) {
}
