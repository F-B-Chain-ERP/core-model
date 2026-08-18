package com.erp.core.enums;

/**
 * Reference scope type used by {@code ia_scope} to partition auth reference data.
 * Confirm exact values with the business model before finalizing.
 */
public enum ScopeType {
    GLOBAL,
    BRANCH,
    DEPARTMENT,
    WAREHOUSE,
    STORE
}
