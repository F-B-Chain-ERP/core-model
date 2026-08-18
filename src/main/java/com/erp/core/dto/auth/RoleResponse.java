package com.erp.core.dto.auth;

import com.erp.core.enums.EntityStatus;
import com.erp.core.enums.RoleType;

/**
 * Read-side projection of {@code IaRole}.
 */
public record RoleResponse(
        String id,
        String code,
        String name,
        String description,
        RoleType roleType,
        EntityStatus status
) {
}
