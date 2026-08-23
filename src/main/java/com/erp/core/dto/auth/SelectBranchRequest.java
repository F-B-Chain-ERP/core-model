package com.erp.core.dto.auth;

import java.util.UUID;

/**
 * Yêu cầu chọn đơn vị (chi nhánh) làm việc sau khi đăng nhập. Branch được chọn
 * phải nằm trong phạm vi (scope) đã được gán cho tài khoản.
 */
public record SelectBranchRequest(
        UUID branchId
) {
}
