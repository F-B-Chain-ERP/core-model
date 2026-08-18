package com.erp.core.constants;

/**
 * Physical table names for the 8 auth reference tables.
 */
public final class TableName {

    public static final String ACCOUNT = "account";
    public static final String ROLE = "role";
    public static final String PERMISSION = "permission";
    public static final String ROLE_PERMISSION = "role_permission";
    public static final String SCOPE = "scope";
    public static final String ACCOUNT_ROLE_ASSIGNMENT = "account_role_assignment";
    public static final String AUDIT_LOG = "audit_log";

    private TableName() {
    }
}
