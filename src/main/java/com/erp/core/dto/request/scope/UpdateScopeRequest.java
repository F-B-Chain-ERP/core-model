package com.erp.core.dto.request.scope;

import com.erp.core.enums.EntityStatus;
import com.erp.core.enums.ScopeType;

import java.util.UUID;

/**
 * Yêu cầu cập nhật phạm vi (Scope). Các trường không truyền (null) sẽ giữ nguyên giá trị hiện tại.
 */
public record UpdateScopeRequest(
        ScopeType scopeType,

        UUID branchId,

        EntityStatus status
) {
}
