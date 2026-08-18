package com.erp.core.dto;

import com.erp.core.enums.EntityStatus;
import com.erp.core.enums.RoleType;

/**
 * Read-side projection of {@code IaRole}.
 */
public class RoleResponse {

    private String id;
    private String code;
    private String name;
    private String description;
    private RoleType roleType;
    private EntityStatus status;

    public RoleResponse() {
    }

    public RoleResponse(String id, String code, String name, String description,
                        RoleType roleType, EntityStatus status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.roleType = roleType;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }
}
