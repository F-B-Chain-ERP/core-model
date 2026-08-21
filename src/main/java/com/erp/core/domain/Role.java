package com.erp.core.domain;

import com.erp.core.enums.EntityStatus;
import com.erp.core.enums.RoleType;
import jakarta.persistence.*;
import com.erp.core.constants.TableName;
import com.erp.core.enums.EntityStatus;
import com.erp.core.enums.RoleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = TableName.ROLE)
public class Role extends BaseAuditingEntity {

    @Column(name = "code", nullable = false, length = 80)
    private String code;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 30)
    private RoleType roleType = RoleType.SYSTEM;
    private RoleType type = RoleType.SYSTEM;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private EntityStatus status = EntityStatus.ACTIVE;

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
    public RoleType getType() {
        return type;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    public void setType(RoleType type) {
        this.type = type;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }
}
