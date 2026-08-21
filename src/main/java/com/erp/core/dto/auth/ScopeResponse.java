package com.erp.core.dto.auth;

import com.erp.core.enums.ScopeType;

import java.util.UUID;

public record ScopeResponse(
        UUID id,
        ScopeType scopeType,
        UUID branchId
) {
}
