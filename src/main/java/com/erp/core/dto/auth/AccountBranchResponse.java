package com.erp.core.dto.auth;

import java.util.UUID;

public record AccountBranchResponse(
        UUID id,
        String code,
        String name,
        boolean primary
) {
}
