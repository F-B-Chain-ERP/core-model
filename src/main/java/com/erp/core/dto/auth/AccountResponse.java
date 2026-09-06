package com.erp.core.dto.auth;

import com.erp.core.enums.AuthProvider;
import com.erp.core.enums.EntityStatus;

import java.time.Instant;
import java.util.UUID;
import java.util.List;

/**
 * Read-side projection of {@code Account}.
 */
public record AccountResponse(
        UUID id,
        String username,
        String email,
        String fullName,
        String phone,
        String avatarUrl,
        AuthProvider authProvider,
        boolean hasLocalPassword,
        EntityStatus status,
        UUID primaryBranchId,
        Instant lastLoginAt,
        Instant createdAt,
        Instant updatedAt,
        List<AssignedBranchResponse> assignedBranches,
        List<UUID> roleIds,
        List<String> roles
) {
    /** Tương thích với các nơi khởi tạo response theo cấu trúc cũ. */
    public AccountResponse(UUID id, String username, String email, String fullName, String phone,
                           String avatarUrl, AuthProvider authProvider, boolean hasLocalPassword,
                           EntityStatus status, UUID primaryBranchId, Instant lastLoginAt,
                           Instant createdAt, Instant updatedAt) {
        this(id, username, email, fullName, phone, avatarUrl, authProvider, hasLocalPassword,
                status, primaryBranchId, lastLoginAt, createdAt, updatedAt, List.of(), List.of(), List.of());
    }
}
