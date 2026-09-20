package com.erp.core.constants;

import java.util.List;

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

    /**
     * 09 mệnh giá tiền mặt Việt Nam đang lưu hành, sắp xếp giảm dần — dùng làm chuẩn
     * cho bảng kiểm kê mệnh giá trên báo cáo chốt ca ({@code STORE_SHIFT_REPORT}).
     */
    public static final List<Long> VND_DENOMINATIONS = List.of(
            500000L, 200000L, 100000L, 50000L, 20000L, 10000L, 5000L, 2000L, 1000L);

    /** Nhãn hiển thị cho mỗi mệnh giá theo danh sách {@link #VND_DENOMINATIONS}. */
    public static String denominationLabel(Long denomination) {
        if (denomination == null) {
            return "";
        }
        return "%1$,.0f ₫".formatted(denomination.doubleValue());
    }

    /** Ngưỡng mặc định: đủ 100 bản ghi trở lên sẽ tự chuyển sang xử lý bất đồng bộ (Async). */
    public static final int DEFAULT_ASYNC_THRESHOLD_RECORDS = 100;

    /** Giới hạn an toàn tối đa cho luồng Sync — chặn ép Sync khi dữ liệu quá lớn (chống OOM). */
    public static final int MAX_HARD_SYNC_RECORDS = 500;

    /** Đường dẫn mặc định của file logo thương hiệu nhúng vào header Excel/PDF. */
    public static final String DEFAULT_LOGO_PATH = "C:/ERP-UTT/image.png";

    /** Chu kỳ polling mặc định của Frontend khi theo dõi trạng thái job Async. */
    public static final int DEFAULT_POLL_INTERVAL_MS = 3000;

    // ==== Mã loại báo cáo (reportType) chuẩn — "hợp đồng" giữa Frontend và Backend ====
    public static final String REPORT_TYPE_POS_ORDER_EXPORT = "POS_ORDER_EXPORT";
    public static final String REPORT_TYPE_POS_SALES_SUMMARY = "POS_SALES_SUMMARY";
    public static final String REPORT_TYPE_STORE_DAILY_REPORT = "STORE_DAILY_REPORT";
    public static final String REPORT_TYPE_STORE_SHIFT_REPORT = "STORE_SHIFT_REPORT";
    public static final String REPORT_TYPE_FIN_SUMMARY_EXPORT = "FIN_SUMMARY_EXPORT";
    public static final String REPORT_TYPE_INV_STOCK_BALANCE = "INV_STOCK_BALANCE";
    public static final String REPORT_TYPE_PROC_PO_EXPORT = "PROC_PO_EXPORT";
}
