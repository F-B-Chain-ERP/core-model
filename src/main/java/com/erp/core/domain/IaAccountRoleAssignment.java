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
    name = TableName.IA_ACCOUNT_ROLE_ASSIGNMENT,
    uniqueConstraints = @UniqueConstraint(
        name = "uk_account_role_scope",
        columnNames = {"account_id", "role_id", "scope_id"}
    )
)
public class IaAccountRoleAssignment extends BaseAuditingEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private IaAccount account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private IaRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scope_id")
    private IaScope scope;

    public IaAccount getAccount() {
        return account;
    }

    public void setAccount(IaAccount account) {
        this.account = account;
    }

    public IaRole getRole() {
        return role;
    }

    public void setRole(IaRole role) {
        this.role = role;
    }

    public IaScope getScope() {
        return scope;
    }

    public void setScope(IaScope scope) {
        this.scope = scope;
    }
}
