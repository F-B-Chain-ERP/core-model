package com.erp.core.constants;

/**
 * Physical table names for the 8 auth reference tables (prefix {@code ia_}).
 */
public final class TableName {

    public static final String IA_ACCOUNT = "ia_account";
    public static final String IA_ROLE = "ia_role";
    public static final String IA_PERMISSION = "ia_permission";
    public static final String IA_ROLE_PERMISSION = "ia_role_permission";
    public static final String IA_SCOPE = "ia_scope";
    public static final String IA_ACCOUNT_ROLE_ASSIGNMENT = "ia_account_role_assignment";
    public static final String IA_AUDIT_LOG = "ia_audit_log";
    public static final String IA_REFRESH_TOKEN = "ia_refresh_token";

    private TableName() {
    }
}
