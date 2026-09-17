package com.erp.core.dto.response.store;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * Phản hồi tóm tắt doanh số POS thời gian thực trước khi chốt ca.
 */
public record ClosingSummaryResponse(
        UUID assignmentId,
        UUID branchId,
        String shiftCode,
        String shiftName,
        UUID cashierId,
        String cashierName,
        Instant checkInAt,
        BigDecimal initialCash,
        BigDecimal cashSales,
        BigDecimal cardSales,
        BigDecimal bankTransferSales,
        BigDecimal ewalletSales,
        BigDecimal totalSales,
        Integer ordersCount,
        BigDecimal cashPayout,
        BigDecimal expectedCash
) {
}
