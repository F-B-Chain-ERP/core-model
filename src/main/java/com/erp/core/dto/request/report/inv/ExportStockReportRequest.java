package com.erp.core.dto.request.report.inv;

import com.erp.core.enums.ExportFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Yêu cầu xuất báo cáo kho hàng (tồn kho, biến động nhập/xuất).
 */
public record ExportStockReportRequest(
        UUID warehouseId,

        UUID materialId,

        String reportType, // BALANCE, STOCK_IN, STOCK_OUT, TRANSFER, COUNT

        LocalDate fromDate,

        LocalDate toDate,

        @NotNull(message = "Định dạng xuất file không được để trống")
        ExportFormat format
) {
}
