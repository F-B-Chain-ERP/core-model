package com.erp.core.dto.request.report.fin;

import com.erp.core.enums.ExportFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Yêu cầu xuất báo cáo tài chính chi nhánh và chi phí.
 */
public record ExportFinancialReportRequest(
        UUID branchId,

        String reportType, // EXPENSE, SUMMARY, PNL

        LocalDate fromDate,

        LocalDate toDate,

        @NotNull(message = "Định dạng xuất file không được để trống")
        ExportFormat format
) {
}
