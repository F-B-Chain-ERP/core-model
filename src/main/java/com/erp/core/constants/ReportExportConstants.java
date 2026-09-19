package com.erp.core.constants;

/**
 * Hằng số tập trung cho tính năng xuất báo cáo.
 *
 * <p>Đây là "hợp đồng chung" duy nhất quản lý các ngưỡng Sync/Async và cấu hình
 * logo — được dùng đồng thời bởi backend-service (điều phối routing), queue-service
 * (worker) và Frontend (qua GET /api/v1/reports/config).</p>
 */
public final class ReportExportConstants {

    private ReportExportConstants() {
    }

    /** Ngưỡng mặc định: đủ 100 bản ghi trở lên sẽ tự chuyển sang xử lý bất đồng bộ (Async). */
    public static final int DEFAULT_ASYNC_THRESHOLD_RECORDS = 100;

    /** Giới hạn an toàn tối đa cho luồng Sync — chặn ép Sync khi dữ liệu quá lớn (chống OOM). */
    public static final int MAX_HARD_SYNC_RECORDS = 500;

    /** Đường dẫn mặc định của file logo thương hiệu nhúng vào header Excel/PDF. */
    public static final String DEFAULT_LOGO_PATH = "C:/ERP-UTT/image.png";

    /** Chu kỳ polling mặc định của Frontend khi theo dõi trạng thái job Async. */
    public static final int DEFAULT_POLL_INTERVAL_MS = 3000;
}
