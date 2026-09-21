package com.erp.core.dto.request.report.proc;

import com.erp.core.enums.ExportFormat;
import com.erp.core.enums.ExportReportMode;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Yêu cầu xuất báo cáo đơn mua hàng (PO).
 */
public record ExportPurchaseOrderReportRequest(
        String search,

        String status,

        UUID supplierId,

        UUID warehouseId,

        LocalDate fromDate,

        LocalDate toDate,

        @NotNull(message = "Định dạng xuất file không được để trống")
        ExportFormat format,

        ExportReportMode mode
) {
    public ExportPurchaseOrderReportRequest {
        if (mode == null) {
            mode = ExportReportMode.AUTO;
        }
    }
}
