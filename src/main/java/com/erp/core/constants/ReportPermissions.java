package com.erp.core.constants;

/**
 * Hằng số quyền hạn (Authority/Permission) áp dụng cho tính năng xuất và xem báo cáo.
 */
public final class ReportPermissions {

    private ReportPermissions() {
    }

    public static final String POS_ORDER_LIST_EXPORT    = "pos:order_report:export";
    public static final String POS_SALES_SUMMARY_EXPORT = "pos:sales_report:export";
    public static final String STORE_SHIFT_VIEW         = "store:shift_report:view";
    public static final String STORE_SHIFT_EXPORT       = "store:shift_report:export";
    public static final String STORE_DAILY_VIEW         = "store:daily_report:view";
    public static final String STORE_DAILY_EXPORT       = "store:daily_report:export";
    public static final String FIN_REPORT_EXPORT        = "fin:report:export";
    public static final String INV_REPORT_EXPORT        = "inv:report:export";
    public static final String PROC_REPORT_EXPORT       = "proc:report:export";
}
