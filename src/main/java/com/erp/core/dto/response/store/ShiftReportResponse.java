package com.erp.core.dto.response.store;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Phản hồi chi tiết biên bản báo cáo chốt ca và kiểm kê két.
 */
public record ShiftReportResponse(
        UUID id,
        UUID assignmentId,
        UUID branchId,
        LocalDate businessDate,
        BigDecimal initialCash,
        BigDecimal cashSales,
        BigDecimal cardSales,
        BigDecimal bankTransferSales,
        BigDecimal ewalletSales,
        BigDecimal totalSales,
        Integer ordersCount,
        BigDecimal cashPayout,
        BigDecimal expectedCash,
        BigDecimal actualCash,
        BigDecimal difference,
        String differenceReason,
        String cashDenominations,
        String status,
        UUID submittedById,
        String submittedByName,
        Instant submittedAt,
        UUID approvedById,
        String approvedByName,
        Instant approvedAt,
        String note,
        Instant createdAt
) {
}
