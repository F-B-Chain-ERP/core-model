package com.erp.core.dto.request.report.store;

import com.erp.core.enums.ExportFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Yêu cầu xuất báo cáo ca làm việc điểm bán.
 */
public record ExportShiftReportRequest(
        UUID branchId,

        LocalDate businessDate,

        LocalDate startDate,

        LocalDate endDate,

        String status,

        @NotNull(message = "Định dạng xuất file không được để trống")
        ExportFormat format
) {
}
