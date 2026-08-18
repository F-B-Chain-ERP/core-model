package com.erp.core.domain;

import com.erp.core.domain.BaseAuditingEntity;
import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = TableName.IA_ROLE_PERMISSION,
    uniqueConstraints = @UniqueConstraint(name = "uk_role_permission", columnNames = {"role_id", "permission_id"})
)
public class IaRolePermission extends BaseAuditingEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private IaRole role;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permission_id", nullable = false)
    private IaPermission permission;

    public IaRole getRole() {
        return role;
    }

    public void setRole(IaRole role) {
        this.role = role;
    }

    public IaPermission getPermission() {
        return permission;
    }

    public void setPermission(IaPermission permission) {
        this.permission = permission;
    }
}
