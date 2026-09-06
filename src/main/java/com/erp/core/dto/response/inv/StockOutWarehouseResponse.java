package com.erp.core.dto.response.inv;

import java.util.UUID;

/**
 * Thông tin kho trong phản hồi phiếu xuất kho.
 */
public record StockOutWarehouseResponse(
        UUID id,
        String code,
        String name
) {
}