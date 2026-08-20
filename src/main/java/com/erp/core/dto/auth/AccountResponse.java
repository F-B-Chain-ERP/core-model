package com.erp.core.dto.auth;

import com.erp.core.enums.AuthProvider;
import com.erp.core.enums.EntityStatus;
import java.time.Instant;
import java.util.UUID;

/**
 * Read-side projection of {@code IaAccount}.
 */
public record AccountResponse(
        UUID id,
        String username,
        String email,
        String fullName,
        AuthProvider authProvider,
        boolean hasLocalPassword,
        EntityStatus status,
        Instant lastLoginAt,
        Instant createdAt,
        Instant updatedAt
) {
}
