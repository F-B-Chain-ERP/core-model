package com.erp.core.dto.request.report.pos;

import com.erp.core.enums.ExportFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Yêu cầu xuất báo cáo đơn hàng POS.
 */
public record ExportOrderReportRequest(
        UUID branchId,

        String orderType,

        String status,

        LocalDate fromDate,

        LocalDate toDate,

        @NotNull(message = "Định dạng xuất file không được để trống")
        ExportFormat format
) {
}
