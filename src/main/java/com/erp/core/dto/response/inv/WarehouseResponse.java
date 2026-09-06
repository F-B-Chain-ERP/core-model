package com.erp.core.dto.response.inv;

import java.time.Instant;

public record WarehouseResponse(
        String id,
        String code,
        String name,
        String warehouseType,
        String branchId,
        String branchName,
        String address,
        String status,
        String createdBy,
        Instant createdAt,
        String updatedBy,
        Instant updatedAt
) {
}
