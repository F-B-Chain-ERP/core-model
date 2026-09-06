package com.erp.core.dto.auth;

import java.util.UUID;

/** Chi nhánh mà tài khoản được gán quyền làm việc. */
public record AssignedBranchResponse(UUID id, String code, String name) {
}
