package com.erp.core.dto.auth;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

/**
 * Vai trò của một tài khoản tại một chi nhánh.
 * {@code roleIds} rỗng nghĩa là thu hồi toàn bộ vai trò của tài khoản ở chi nhánh đó.
 */
public record AccountBranchRoleRequest(
        @NotNull(message = "Branch id must not be null")
        UUID branchId,

        @NotNull(message = "Role ids must not be null")
        List<UUID> roleIds
) {
}
