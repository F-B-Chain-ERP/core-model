package com.erp.core.dto.response.branch;

public record BranchSalesResponse(
        String id,
        String code,
        String name,
        String address,
        String phone,
        boolean supportsPickup,
        boolean supportsDelivery
) {
}
