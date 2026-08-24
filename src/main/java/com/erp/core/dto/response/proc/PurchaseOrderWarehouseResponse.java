package com.erp.core.dto.response.proc;

/**
 * Thông tin kho nhận rút gọn trong phản hồi đơn mua hàng.
 */
public record PurchaseOrderWarehouseResponse(
        String id,
        String code,
        String name
) {
}
