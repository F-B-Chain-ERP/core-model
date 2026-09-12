package com.erp.core.dto.response.menu;

import java.util.List;

/**
 * Chi tiết voucher kèm danh sách chi nhánh được gán.
 */
public record VoucherDetailResponse(
        /** Thông tin chung của voucher. */
        VoucherResponse voucher,

        /** Danh sách chi nhánh được gán cho voucher. */
        List<VoucherBranchResponse> branches
) {
}