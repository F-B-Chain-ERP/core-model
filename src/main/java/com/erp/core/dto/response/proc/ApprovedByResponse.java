package com.erp.core.dto.response.proc;

/**
 * Thông tin người phê duyệt rút gọn trong phản hồi đơn mua hàng.
 */
public record ApprovedByResponse(
        String id,
        String fullName
) {
}
