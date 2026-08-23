package com.erp.core.dto.auth;

import com.erp.core.enums.AuthProvider;
import com.erp.core.enums.EntityStatus;

import java.time.Instant;
import java.util.UUID;

/**
 * Thông tin khách hàng trả về sau đăng ký / đăng nhập.
 */
public record CustomerResponse(
        UUID id,
        String customerCode,
        String fullName,
        String phone,
        String email,
        AuthProvider authProvider,
        boolean hasLocalPassword,
        boolean emailVerified,
        EntityStatus status,
        Instant lastLoginAt,
        Instant createdAt,
        Instant updatedAt
) {
}
