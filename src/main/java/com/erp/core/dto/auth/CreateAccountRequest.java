package com.erp.core.dto.auth;

import com.erp.core.enums.AuthProvider;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu tạo tài khoản nội bộ (account) bởi admin. Khác với đăng ký khách hàng,
 * tài khoản nội bộ KHÔNG tự đăng ký mà do người quản trị cấp.
 * Khi tạo nhân viên, bắt buộc phải chọn chi nhánh (primaryBranchId).
 * Vai trò (roleIds) có thể bỏ trống và phân quyền sau.
 */
public record CreateAccountRequest(
        @NotBlank(message = "Username must not be blank")
        @Size(max = 100, message = "Username must not exceed 100 characters")
        String username,

        @NotBlank(message = "Password must not be blank")
        @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
        String password,

        @NotBlank(message = "Full name must not be blank")
        @Size(max = 150, message = "Full name must not exceed 150 characters")
        String fullName,

        @Email(message = "Email is invalid")
        String email,

        @Pattern(regexp = "^[0-9+\\-\\s]{8,20}$", message = "Phone is invalid")
        String phone,

        @NotNull(message = "Primary branch is required")
        UUID primaryBranchId,

        AuthProvider authProvider,

        List<UUID> roleIds
) {
}
