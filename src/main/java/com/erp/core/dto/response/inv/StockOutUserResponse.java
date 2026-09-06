package com.erp.core.dto.response.inv;

import java.util.UUID;

/**
 * Thông tin người xuất trong phản hồi phiếu xuất kho.
 */
public record StockOutUserResponse(
        UUID id,
        String fullName
) {
}