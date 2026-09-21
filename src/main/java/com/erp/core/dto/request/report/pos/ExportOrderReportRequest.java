package com.erp.core.dto.request.report.pos;

import com.erp.core.enums.ExportFormat;
import com.erp.core.enums.ExportReportMode;
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
        ExportFormat format,

        ExportReportMode mode,

        /**
         * Mã loại báo cáo POS: {@code POS_ORDER_EXPORT} (mặc định) hoặc {@code POS_SALES_SUMMARY}.
         */
        String reportType
) {
    public ExportOrderReportRequest {
        if (mode == null) {
            mode = ExportReportMode.AUTO;
        }
        if (reportType == null) {
            reportType = com.erp.core.constants.ReportExportConstants.REPORT_TYPE_POS_ORDER_EXPORT;
        }
    }
}
