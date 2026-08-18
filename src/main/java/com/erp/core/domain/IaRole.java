package com.erp.core.domain;

import com.erp.core.domain.BaseAuditingEntity;
import com.erp.core.constants.TableName;
import com.erp.core.enums.RoleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = TableName.IA_ROLE)
public class IaRole extends BaseAuditingEntity {

    @Column(name = "code", unique = true, length = 100, nullable = false)
    private String code;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", length = 20, nullable = false)
    private RoleType roleType = RoleType.LOCAL;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getStatus() {
        return super.getStatus();
    }
}
