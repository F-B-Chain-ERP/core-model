package com.erp.core.enums;

/**
 * Mục đích sử dụng mã OTP, quyết định namespace Redis và nội dung email gửi đi.
 */
public enum OtpPurpose {
    /** Xác thực email khi đăng ký tài khoản mới. */
    REGISTRATION,
    /** Đặt lại mật khẩu (quên mật khẩu). */
    PASSWORD_RESET
}
