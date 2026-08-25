package com.erp.core.dto.auth;

import com.erp.core.enums.EntityStatus;
import com.erp.core.enums.ScopeType;

import java.util.UUID;

/**
 * Projection đọc của {@code Scope} dành cho màn quản trị phạm vi,
 * bao gồm tên chi nhánh liên quan để hiển thị danh sách.
 */
public record ScopeAdminResponse(
        UUID id,
        ScopeType scopeType,
        UUID branchId,
        String branchName,
        EntityStatus status
) {
}
