package com.erp.core.dto.response.menu;

import java.time.Instant;

/**
 * Read-side projection của {@code VoucherBranch}, kèm tên chi nhánh.
 */
public record VoucherBranchResponse(
        /** ID bản ghi gán voucher - chi nhánh (UUID dạng chuỗi). */
        String id,

        /** ID voucher (UUID dạng chuỗi). */
        String voucherId,

        /** ID chi nhánh (UUID dạng chuỗi). */
        String branchId,

        /** Tên chi nhánh được gán. */
        String branchName,

        /** Trạng thái gán: ACTIVE hoặc INACTIVE. */
        String status,

        /** Người tạo bản ghi. */
        String createdBy,

        /** Thời điểm tạo. */
        Instant createdAt,

        /** Người cập nhật gần nhất. */
        String updatedBy,

        /** Thời điểm cập nhật gần nhất. */
        Instant updatedAt
) {
}