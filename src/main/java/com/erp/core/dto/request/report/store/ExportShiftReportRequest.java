package com.erp.core.dto.request.report.store;

import com.erp.core.enums.ExportFormat;
import com.erp.core.enums.ExportReportMode;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Yêu cầu xuất báo cáo ca làm việc điểm bán.
 */
public record ExportShiftReportRequest(
        UUID branchId,

        UUID shiftReportId,

        LocalDate businessDate,

        LocalDate startDate,

        LocalDate endDate,

        String status,

        @NotNull(message = "Định dạng xuất file không được để trống")
        ExportFormat format,

        ExportReportMode mode
) {
    public ExportShiftReportRequest {
        if (mode == null) {
            mode = ExportReportMode.AUTO;
        }
    }

    public ExportShiftReportRequest(UUID branchId, LocalDate businessDate, LocalDate startDate, LocalDate endDate,
                                  String status, ExportFormat format, ExportReportMode mode) {
        this(branchId, null, businessDate, startDate, endDate, status, format, mode);
    }
}
