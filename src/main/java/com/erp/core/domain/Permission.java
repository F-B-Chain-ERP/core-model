package com.erp.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import com.erp.core.constants.TableName;
import jakarta.persistence.Table;

@Entity
@Table(name = TableName.PERMISSION)
public class Permission extends BaseAuditingEntity {

    @Column(name = "code", nullable = false, length = 120)
    private String code;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "module", nullable = false, length = 80)
    private String module;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "status", nullable = false, length = 30)
    private String status = "ACTIVE";

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

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
