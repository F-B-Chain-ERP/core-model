package com.erp.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * Mapped superclass for tenant-scoped business tables. Adds the row-level
 * {@code tenant_id} column that drives multi-tenancy. Auth reference tables
 * intentionally do NOT extend this class because they are cross-tenant.
 */
@MappedSuperclass
public abstract class BaseTenantEntity extends BaseAuditingEntity {

    @Column(name = "tenant_id", columnDefinition = "char(36)", length = 36, nullable = false)
    private String tenantId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
