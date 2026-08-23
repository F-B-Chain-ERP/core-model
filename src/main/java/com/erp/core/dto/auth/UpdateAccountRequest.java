package com.erp.core.dto.auth;

import com.erp.core.enums.EntityStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

/**
 * Yêu cầu cập nhật thông tin tài khoản nội bộ (account) bởi admin.
 * Tất cả trường đều tùy chọn: chỉ những trường khác {@code null} mới được áp dụng.
 */
public record UpdateAccountRequest(
        @Size(max = 150, message = "Full name must not exceed 150 characters")
        String fullName,

        @Email(message = "Email is invalid")
        String email,

        @Pattern(regexp = "^[0-9+\\-\\s]{8,20}$", message = "Phone is invalid")
        String phone,

        @Size(max = 500, message = "Avatar URL must not exceed 500 characters")
        String avatarUrl,

        UUID primaryBranchId,

        EntityStatus status
) {
}
