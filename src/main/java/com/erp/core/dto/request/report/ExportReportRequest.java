package com.erp.core.dto.request.report;

import com.erp.core.enums.ExportFormat;
import com.erp.core.enums.ExportReportMode;
import com.erp.core.enums.ReportModule;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO cơ sở chứa tham số chung cho yêu cầu xuất báo cáo.
 */
public record ExportReportRequest(
        @NotNull(message = "Phân hệ báo cáo không được để trống")
        ReportModule module,

        @NotNull(message = "Loại báo cáo không được để trống")
        String reportType,

        @NotNull(message = "Định dạng xuất file không được để trống")
        ExportFormat format,

        UUID branchId,

        LocalDate fromDate,

        LocalDate toDate,

        String note,

        /**
         * Chế độ điều phối: {@code AUTO} (mặc định — tự chọn Sync/Async theo ngưỡng),
         * {@code SYNC} (ép đồng bộ) hoặc {@code ASYNC} (ép bất đồng bộ).
         * Nếu để {@code null} hệ thống xử lý như {@code AUTO}.
         */
        ExportReportMode mode
) {
    public ExportReportRequest {
        if (mode == null) {
            mode = ExportReportMode.AUTO;
        }
    }
}
