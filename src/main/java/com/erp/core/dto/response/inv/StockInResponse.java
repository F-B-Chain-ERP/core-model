package com.erp.core.dto.response.inv;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Read-side projection của {@code StockIn}, bao gồm thông tin kho, người ghi nhận,
 * tham chiếu nguồn và danh sách dòng chi tiết (khớp hợp đồng SRS 3.7).
 */
public record StockInResponse(
        String id,
        String code,
        String warehouseId,
        String status,
        StockInWarehouseResponse warehouse,
        String sourceType,
        UUID sourceReferenceId,
        String purchaseOrderStatus,
        LocalDate inDate,
        String note,
        StockInUserResponse receivedBy,
        Instant postedAt,
        List<StockInItemResponse> items,
        String createdBy,
        Instant createdAt
) {
}