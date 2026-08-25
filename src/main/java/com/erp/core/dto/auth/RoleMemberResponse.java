package com.erp.core.dto.auth;

import java.time.Instant;
import java.util.UUID;

/**
 * Thông tin tài khoản là thành viên của một vai trò, dùng cho endpoint
 * {@code GET /api/v1/roles/{id}/users}. Kết hợp dữ liệu account và thời điểm gán.
 */
public record RoleMemberResponse(
        UUID id,
        String username,
        String fullName,
        String email,
        String department,
        Instant assignedAt
) {}
