package com.erp.core.dto.request.proc;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu tạo mới đơn mua hàng (kèm danh sách dòng chi tiết). Mã đơn (poCode) tùy chọn,
 * nếu để trống hệ thống sẽ tự sinh.
 */
public record CreatePurchaseOrderRequest(
        String poCode,

        @NotNull(message = "Nhà cung cấp không được để trống")
        UUID supplierId,

        @NotNull(message = "Kho nhận không được để trống")
        UUID warehouseId,

        LocalDate orderDate,

        LocalDate expectedDate,

        @Size(max = 500, message = "Ghi chú không được vượt quá 500 ký tự")
        String note,

        @NotEmpty(message = "Đơn mua hàng phải có ít nhất một dòng chi tiết")
        List<PurchaseOrderItemRequest> items
) {
}
