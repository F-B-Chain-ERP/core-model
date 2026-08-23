package com.erp.core.domain;

import com.erp.core.constants.TableName;
import com.erp.core.constants.Defaults;
import com.erp.core.enums.EntityStatus;
import com.erp.core.enums.PrincipalType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

/**
 * Refresh token lưu trữ trên DB theo mô hình đa hình (principal_type + principal_id),
 * dùng chung cho cả tài khoản nội bộ (ACCOUNT) và khách hàng (CUSTOMER).
 * Token thật chỉ lưu dưới dạng mã băm (token_hash); không lưu plaintext.
 */
@Entity
@Table(name = TableName.REFRESH_TOKEN, indexes = {
        @Index(name = "idx_refresh_principal", columnList = "principal_type, principal_id, expires_at"),
        @Index(name = "idx_refresh_token_hash", columnList = "token_hash", unique = true)
})
public class RefreshToken extends BaseAuditingEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private EntityStatus status = Defaults.DEFAULT_STATUS;

    @Enumerated(EnumType.STRING)
    @Column(name = "principal_type", nullable = false, length = 20)
    private PrincipalType principalType;

    @Column(name = "principal_id", nullable = false)
    private UUID principalId;

    @Column(name = "token_hash", nullable = false, length = 255, unique = true)
    private String tokenHash;

    @Column(name = "device_info", length = 255)
    private String deviceInfo;

    @Column(name = "ip_address", length = 64)
    private String ipAddress;

    @Column(name = "expires_at", nullable = false)
    private Instant expiresAt;

    @Column(name = "revoked_at")
    private Instant revokedAt;

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public PrincipalType getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(PrincipalType principalType) {
        this.principalType = principalType;
    }

    public UUID getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(UUID principalId) {
        this.principalId = principalId;
    }

    public String getTokenHash() {
        return tokenHash;
    }

    public void setTokenHash(String tokenHash) {
        this.tokenHash = tokenHash;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Instant getRevokedAt() {
        return revokedAt;
    }

    public void setRevokedAt(Instant revokedAt) {
        this.revokedAt = revokedAt;
    }
}
