package com.erp.core.dto.request.report.store;

import com.erp.core.enums.ExportFormat;
import com.erp.core.enums.ExportReportMode;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Yêu cầu xuất báo cáo ngày chi nhánh cửa hàng.
 */
public record ExportDailyReportRequest(
        UUID branchId,

        LocalDate startDate,

        LocalDate endDate,

        String status,

        @NotNull(message = "Định dạng xuất file không được để trống")
        ExportFormat format,

        ExportReportMode mode
) {
    public ExportDailyReportRequest {
        if (mode == null) {
            mode = ExportReportMode.AUTO;
        }
    }
}
