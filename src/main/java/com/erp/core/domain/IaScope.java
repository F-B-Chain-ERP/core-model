package com.erp.core.domain;

import com.erp.core.domain.BaseAuditingEntity;
import com.erp.core.constants.TableName;
import com.erp.core.enums.ScopeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = TableName.IA_SCOPE,
    uniqueConstraints = @UniqueConstraint(name = "uk_scope_type_branch", columnNames = {"scope_type", "branch_id"})
)
public class IaScope extends BaseAuditingEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "scope_type", length = 20, nullable = false)
    private ScopeType scopeType;

    @Column(name = "branch_id", columnDefinition = "char(36)", length = 36)
    private String branchId;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    public ScopeType getScopeType() {
        return scopeType;
    }

    public void setScopeType(ScopeType scopeType) {
        this.scopeType = scopeType;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
