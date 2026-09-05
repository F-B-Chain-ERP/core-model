package com.erp.core.dto.response.inv;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Read-side projection của {@code StockOut}, bao gồm thông tin kho, người xuất,
 * tham chiếu đích và danh sách dòng chi tiết (khớp hợp đồng SRS 3.7).
 */
public record StockOutResponse(
        String id,
        String code,
        String warehouseId,
        String status,
        StockOutWarehouseResponse warehouse,
        String destinationType,
        UUID destinationReferenceId,
        LocalDate outDate,
        String note,
        StockOutUserResponse issuedBy,
        Instant postedAt,
        List<StockOutItemResponse> items,
        String createdBy,
        Instant createdAt
) {
}