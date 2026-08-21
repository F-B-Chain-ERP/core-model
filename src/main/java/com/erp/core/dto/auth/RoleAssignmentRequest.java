package com.erp.core.dto.auth;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record RoleAssignmentRequest(
        @NotNull(message = "Account id must not be null")
        UUID accountId,

        @NotNull(message = "Role id must not be null")
        UUID roleId,

        @NotNull(message = "Scope id must not be null")
        UUID scopeId,

        @Future(message = "Expiration time must be in the future")
        Instant expiresAt
) {
}
