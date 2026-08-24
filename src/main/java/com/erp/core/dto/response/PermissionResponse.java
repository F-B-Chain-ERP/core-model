package com.erp.core.dto.response;

import com.erp.core.enums.EntityStatus;

/**
 * Read-side projection of {@code Permission}.
 */
public record PermissionResponse(
        String id,
        String code,
        String name,
        String module,
        String description,
        EntityStatus status
) {
}
