package com.erp.core.dto.auth;

import com.erp.core.enums.PrincipalType;

/**
 * Kết quả xác thực trả về client, gồm cặp token và thông tin thực thể đăng nhập
 * (tài khoản nội bộ hoặc khách hàng, phân biệt bởi {@code principalType}).
 */
public record AuthResponse(
        String accessToken,
        String refreshToken,
        String tokenType,
        PrincipalType principalType,
        CustomerResponse customer,
        boolean requiresScopeAssignment,
        boolean requiresEmailVerification,
        String verifyToken
) {
}
