package com.erp.core.dto.auth;

import com.erp.core.enums.EntityStatus;

import java.time.Instant;
import java.util.UUID;

public record RoleAssignmentResponse(
        UUID id,
        UUID accountId,
        UUID roleId,
        ScopeResponse scope,
        EntityStatus status,
        Instant assignedAt,
        Instant expiresAt
) {
}
