package com.erp.core.dto.response.proc;

import java.time.Instant;

/**
 * Read-side projection của {@code Supplier}.
 */
public record SupplierResponse(
        String id,
        String code,
        String name,
        String taxCode,
        String contactName,
        String phone,
        String email,
        String address,
        Integer paymentTermDays,
        String status,
        String createdBy,
        Instant createdAt
) {
}
