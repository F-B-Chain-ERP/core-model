package com.erp.core.dto.auth;

public record AuthResponse(
        String accessToken,
        String refreshToken,
        String tokenType,
        AccountResponse account,
        boolean requiresScopeAssignment
) {
}
