package com.erp.core.enums;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Các loại báo cáo chuẩn do hệ thống hỗ trợ xuất.
 *
 * <p>Mỗi giá trị mang một mã chuẩn ({@link #getCode()}) dùng làm "hợp đồng" giữa
 * Frontend và Backend. Riêng nhóm POS giữ cả bí danh của tài liệu thiết kế
 * ({@code ORDER_LIST}, {@code SALES_SUMMARY}) để dùng được cả hai cách đặt tên:
 * {@link #from(String)} sẽ chuẩn hoá về mã chuẩn.</p>
 */
public enum ReportType {

    /** Danh sách đơn hàng POS (thiết kế: ORDER_LIST). */
    POS_ORDER_EXPORT("ORDER_LIST"),
    /** Tổng hợp doanh thu POS theo sản phẩm/biến thể (thiết kế: SALES_SUMMARY). */
    POS_SALES_SUMMARY("SALES_SUMMARY"),
    /** Báo cáo tổng hợp ngày cho cửa hàng. */
    STORE_DAILY_REPORT(null),
    /** Báo cáo chốt ca cho cửa hàng. */
    STORE_SHIFT_REPORT(null),
    /** Báo cáo tổng hợp tài chính. */
    FIN_SUMMARY_EXPORT(null),
    /** Báo cáo tồn kho. */
    INV_STOCK_BALANCE(null),
    /** Báo cáo đơn mua hàng (Procurement). */
    PROC_PO_EXPORT(null);

    private static final Map<String, ReportType> LOOKUP = new HashMap<>();

    static {
        for (ReportType type : values()) {
            LOOKUP.put(type.name().toLowerCase(Locale.ROOT), type);
            if (type.legacyAlias != null) {
                LOOKUP.put(type.legacyAlias.toLowerCase(Locale.ROOT), type);
            }
        }
    }

    private final String legacyAlias;

    ReportType(String legacyAlias) {
        this.legacyAlias = legacyAlias;
    }

    /** Mã chuẩn dùng để trao đổi với Frontend (bằng {@code name()} của enum). */
    public String getCode() {
        return name();
    }

    /**
     * Chuẩn hoá một chuỗi loại báo cáo về {@link ReportType} tương ứng.
     *
     * @param type tên loại báo cáo (mã chuẩn hoặc bí danh thiết kế như ORDER_LIST, SALES_SUMMARY)
     * @return enum tương ứng, hoặc {@code null} nếu không nhận diện được
     */
    public static ReportType from(String type) {
        if (type == null || type.isBlank()) {
            return null;
        }
        return LOOKUP.get(type.trim().toLowerCase(Locale.ROOT));
    }

    /**
     * Chuẩn hoá như {@link #from(String)} nhưng giữ nguyên chuỗi gốc nếu không nhận diện
     * được — an toàn cho việc truyền thẳng reportType xuống worker.
     */
    public static String normalize(String type) {
        ReportType resolved = from(type);
        return resolved != null ? resolved.getCode() : type;
    }
}