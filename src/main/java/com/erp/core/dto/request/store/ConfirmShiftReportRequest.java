package com.erp.core.dto.request.store;

import jakarta.validation.constraints.Size;

/**
 * Yêu cầu xác nhận / phê duyệt biên bản bàn giao ca của Trưởng ca.
 */
public record ConfirmShiftReportRequest(
        @Size(max = 500, message = "Ghi chú tối đa 500 ký tự")
        String note
) {
}
