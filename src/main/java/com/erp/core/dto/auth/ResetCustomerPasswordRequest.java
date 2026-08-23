package com.erp.core.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Yêu cầu đặt lại mật khẩu cho một khách hàng (do admin thực hiện).
 */
public record ResetCustomerPasswordRequest(
        @NotBlank(message = "Password must not be blank")
        @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
        String password
) {
}
