package com.erp.core.dto.response.report;

import java.time.Instant;
import java.util.UUID;

/**
 * Phản hồi chi tiết trạng thái tác vụ xuất báo cáo.
 */
public record ReportJobResponse(
        UUID id,
        String module,
        String reportType,
        String status,
        String format,
        UUID requestedBy,
        UUID branchId,
        Integer estimatedRows,
        String fileUrl,
        String errorMessage,
        Instant startedAt,
        Instant completedAt,
        Instant createdAt
) {
}
