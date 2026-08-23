package com.erp.core.enums;

/**
 * Loại định danh (thực thể) sở hữu một phiên xác thực.
 * Dùng để phân biệt tài khoản nội bộ (ACCOUNT) và khách hàng (CUSTOMER)
 * trong JWT, refresh token và audit log.
 */
public enum PrincipalType {
    ACCOUNT,
    CUSTOMER
}
