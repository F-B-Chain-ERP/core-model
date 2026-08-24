package com.erp.core.dto.response.proc;

/**
 * Thông tin nhà cung cấp rút gọn trong phản hồi đơn mua hàng.
 */
public record PurchaseOrderSupplierResponse(
        String id,
        String code,
        String name
) {
}
