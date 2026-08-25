package com.erp.core.dto.request.scope;

import com.erp.core.enums.EntityStatus;
import com.erp.core.enums.ScopeType;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/**
 * Yêu cầu tạo mới phạm vi (Scope). Với loại ALL_SYSTEM không cần branchId,
 * các loại gắn chi nhánh (STORE, WAREHOUSE) bắt buộc cung cấp branchId.
 */
public record CreateScopeRequest(
        @NotNull(message = "Loại phạm vi không được để trống")
        ScopeType scopeType,

        UUID branchId,

        EntityStatus status
) {
}
