package com.erp.core.domain;

import com.erp.core.constants.TableName;
import com.erp.core.enums.EntityStatus;
import com.erp.core.enums.PrincipalType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.util.Map;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * Bản ghi lịch sử hệ thống (audit log).
 * Actor được mô hình hóa đa hình qua {@code actorType} + {@code actorId}
 * để ghi nhận cả tài khoản nội bộ (ACCOUNT) lẫn khách hàng (CUSTOMER).
 */
@Entity
@Table(name = TableName.AUDIT_LOG)
public class AuditLog extends BaseAuditingEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private EntityStatus status = EntityStatus.ACTIVE;

    @Enumerated(EnumType.STRING)
    @Column(name = "actor_type", length = 20)
    private PrincipalType actorType;

    @Column(name = "actor_id")
    private UUID actorId;

    @Column(name = "action", nullable = false, length = 100)
    private String action;

    @Column(name = "module", nullable = false, length = 80)
    private String module;

    @Column(name = "target_type", length = 80)
    private String targetType;

    @Column(name = "target_id")
    private UUID targetId;

    @Column(name = "branch_id")
    private UUID branchId;

    @Column(name = "ip_address", length = 64)
    private String ipAddress;

    @Column(name = "user_agent", length = 500)
    private String userAgent;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "before_data", columnDefinition = "jsonb")
    private Map<String, Object> beforeData;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "after_data", columnDefinition = "jsonb")
    private Map<String, Object> afterData;

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public PrincipalType getActorType() {
        return actorType;
    }

    public void setActorType(PrincipalType actorType) {
        this.actorType = actorType;
    }

    public UUID getActorId() {
        return actorId;
    }

    public void setActorId(UUID actorId) {
        this.actorId = actorId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public UUID getTargetId() {
        return targetId;
    }

    public void setTargetId(UUID targetId) {
        this.targetId = targetId;
    }

    public UUID getBranchId() {
        return branchId;
    }

    public void setBranchId(UUID branchId) {
        this.branchId = branchId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Map<String, Object> getBeforeData() {
        return beforeData;
    }

    public void setBeforeData(Map<String, Object> beforeData) {
        this.beforeData = beforeData;
    }

    public Map<String, Object> getAfterData() {
        return afterData;
    }

    public void setAfterData(Map<String, Object> afterData) {
        this.afterData = afterData;
    }
}
