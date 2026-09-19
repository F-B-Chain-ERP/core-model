package com.erp.core.dto.response.report;

import java.util.List;

/**
 * Cấu hình xuất báo cáo trả về cho Frontend qua {@code GET /api/v1/reports/config}.
 *
 * <p>Đây là cầu nối duy nhất để Frontend biết ngưỡng Sync/Async, các định dạng
 * hỗ trợ và chu kỳ polling — không cần hard-code trùng lặp ở Frontend.</p>
 *
 * @param asyncThresholdRecords ngưỡng bản ghi: từ đây trở lên chuyển sang Async (vd: 100)
 * @param maxHardSyncRecords    giới hạn an toàn tối đa cho luồng Sync (chống OOM, vd: 500)
 * @param supportedFormats      danh sách định dạng hỗ trợ (EXCEL, PDF, CSV)
 * @param pollIntervalMs        chu kỳ polling job khi Frontend theo dõi trạng thái Async
 * @param sseEnabled            hệ thống có bật SSE đẩy thông báo realtime hay không
 */
public record ReportConfigResponse(
        int asyncThresholdRecords,
        int maxHardSyncRecords,
        List<String> supportedFormats,
        int pollIntervalMs,
        boolean sseEnabled
) {
}
