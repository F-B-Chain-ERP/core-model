package com.erp.core.dto.response.inv;

import java.util.List;
import java.util.UUID;

/**
 * Thông tin kho trong phản hồi phiếu nhập/xuất kho.
 */
public record StockInWarehouseResponse(
        UUID id,
        String code,
        String name
) {
}