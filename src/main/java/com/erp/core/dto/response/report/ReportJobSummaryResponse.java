package com.erp.core.dto.response.report;

import java.time.Instant;
import java.util.UUID;

/**
 * Phản hồi tóm tắt danh sách tác vụ xuất báo cáo người dùng.
 */
public record ReportJobSummaryResponse(
        UUID id,
        String module,
        String reportType,
        String status,
        String format,
        String fileUrl,
        Instant completedAt,
        Instant createdAt
) {
}
