package com.erp.core.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Các loại báo cáo chuẩn do hệ thống hỗ trợ xuất.
 *
 * <p>Mỗi giá trị mang một mã chuẩn ({@link #getCode()}) dùng làm "hợp đồng" giữa
 * Frontend và Backend. Hệ thống hỗ trợ đa bí danh (aliases) để tương thích ngược
 * với các phiên bản cũ và mã thiết kế.</p>
 */
public enum ReportType {

    /** Danh sách đơn hàng POS (thiết kế: ORDER_LIST, legacy: POS_ORDER_EXPORT). */
    POS_ORDER_LIST(List.of("ORDER_LIST", "POS_ORDER_EXPORT")),
    /** Tổng hợp doanh thu POS theo sản phẩm/biến thể (thiết kế: SALES_SUMMARY). */
    POS_SALES_SUMMARY(List.of("SALES_SUMMARY")),
    /** Báo cáo chốt ca bán hàng cho 1 ca duy nhất (biên bản bàn giao ca). */
    STORE_SHIFT_HANDOVER(List.of("STORE_SHIFT_REPORT", "SHIFT_HANDOVER")),
    /** Danh sách các ca làm việc của cửa hàng theo khoảng thời gian. */
    STORE_SHIFT_LIST(List.of("SHIFT_LIST")),
    /** Báo cáo tổng hợp doanh thu ngày của chi nhánh (chi tiết theo từng ca trong ngày). */
    STORE_DAILY_CLOSING(List.of("STORE_DAILY_REPORT", "DAILY_CLOSING")),
    /** Danh sách tổng hợp nhiều ngày theo khoảng thời gian. */
    STORE_DAILY_LIST(List.of("DAILY_LIST")),
    /** Báo cáo tổng hợp tài chính. */
    FIN_SUMMARY_EXPORT(List.of()),
    /** Báo cáo tồn kho. */
    INV_STOCK_BALANCE(List.of()),
    /** Báo cáo đơn mua hàng (Procurement). */
    PROC_PO_EXPORT(List.of()),

    // Legacy enum constants để đảm bảo 100% tương thích ngược khi compile code cũ:
    POS_ORDER_EXPORT(List.of("ORDER_LIST")),
    STORE_SHIFT_REPORT(List.of("STORE_SHIFT_HANDOVER")),
    STORE_DAILY_REPORT(List.of("STORE_DAILY_CLOSING"));

    private static final Map<String, ReportType> LOOKUP = new HashMap<>();

    static {
        for (ReportType type : values()) {
            LOOKUP.putIfAbsent(type.name().toLowerCase(Locale.ROOT), type);
            for (String alias : type.aliases) {
                LOOKUP.putIfAbsent(alias.toLowerCase(Locale.ROOT), type);
            }
        }
    }

    private final List<String> aliases;

    ReportType(List<String> aliases) {
        this.aliases = aliases != null ? aliases : List.of();
    }

    /** Mã chuẩn dùng để trao đổi với Frontend (bằng {@code name()} của enum). */
    public String getCode() {
        return switch (this) {
            case POS_ORDER_EXPORT -> POS_ORDER_LIST.name();
            case STORE_SHIFT_REPORT -> STORE_SHIFT_HANDOVER.name();
            case STORE_DAILY_REPORT -> STORE_DAILY_CLOSING.name();
            default -> name();
        };
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