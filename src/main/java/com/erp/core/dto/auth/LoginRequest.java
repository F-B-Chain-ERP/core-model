package com.erp.core.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Username or email must not be blank")
        String usernameOrEmail,
        
        @NotBlank(message = "Password must not be blank")
        String password
) {
}
