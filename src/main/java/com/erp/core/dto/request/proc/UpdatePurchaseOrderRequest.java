package com.erp.core.dto.request.proc;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu cập nhật đơn mua hàng. Chỉ áp dụng khi đơn ở trạng thái DRAFT.
 * Nếu {@code items} khác null, danh sách dòng chi tiết sẽ được thay thế toàn bộ.
 */
public record UpdatePurchaseOrderRequest(
        UUID supplierId,
        UUID warehouseId,
        LocalDate orderDate,
        LocalDate expectedDate,
        @Size(max = 500, message = "Ghi chú không được vượt quá 500 ký tự")
        String note,
        List<PurchaseOrderItemRequest> items
) {
}
