package com.erp.core.dto.response.inv;

import java.util.UUID;

/**
 * Thông tin người ghi nhận trong phản hồi phiếu nhập kho.
 */
public record StockInUserResponse(
        UUID id,
        String fullName
) {
}