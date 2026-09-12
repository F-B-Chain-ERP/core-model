package com.erp.core.dto.request.menu;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * Yêu cầu gán voucher cho một danh sách chi nhánh.
 */
public record AssignVoucherBranchRequest(

        @NotEmpty(message = "Danh sách chi nhánh không được để trống")
        List<@NotNull(message = "Mã chi nhánh không được để trống") UUID> branchIds
) {
}