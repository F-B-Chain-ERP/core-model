package com.erp.core.dto.response.branch;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Read-side projection của {@code Branch}, bao gồm thông tin quan hệ cha-con
 * (parentId, parentName) để hiển thị cây chi nhánh.
 */
public record BranchResponse(
        String id,
        String code,
        String name,
        String address,
        String phone,
        String email,
        BigDecimal latitude,
        BigDecimal longitude,
        String timezone,
        boolean supportsPickup,
        boolean supportsDelivery,
        int averagePreparationMinutes,
        String status,
        String parentId,
        String parentName
) {
}
