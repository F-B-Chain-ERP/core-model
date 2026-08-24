package com.erp.core.dto.response.customer;

import com.erp.core.enums.AuthProvider;
import com.erp.core.enums.EntityStatus;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Thông tin khách hàng trả về ở nghiệp vụ quản lý bởi admin nội bộ
 * (nhiều trường hơn {@code CustomerResponse} dùng cho xác thực).
 */
public record CustomerDetailResponse(
        UUID id,
        String customerCode,
        String username,
        String fullName,
        String phone,
        String email,
        AuthProvider authProvider,
        boolean hasLocalPassword,
        boolean emailVerified,
        String avatarUrl,
        LocalDate dateOfBirth,
        String gender,
        EntityStatus status,
        Instant lastLoginAt,
        Instant createdAt,
        Instant updatedAt
) {
}
