package com.erp.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import com.erp.core.constants.TableName;
import com.erp.core.constants.Defaults;
import com.erp.core.enums.AuthProvider;
import com.erp.core.enums.EntityStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = TableName.ACCOUNT)
public class Account extends BaseAuditingEntity {

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "full_name", nullable = false, length = 150)
    private String fullName;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "avatar_url", length = 500)
    private String avatarUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private EntityStatus status = Defaults.DEFAULT_STATUS;

    @Column(name = "last_login_at")
    private Instant lastLoginAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider", nullable = false, length = 50)
    private AuthProvider authProvider = Defaults.DEFAULT_AUTH_PROVIDER;

    @Column(name = "provider_id", length = 255)
    private String providerId;

    @Column(name = "system_protected", nullable = false)
    private boolean systemProtected;

    @Column(name = "primary_branch_id")
    private UUID primaryBranchId;

    @Column(name = "has_local_password", nullable = false)
    private boolean hasLocalPassword = true;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public Instant getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(Instant lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public AuthProvider getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public boolean isSystemProtected() { return systemProtected; }
    public void setSystemProtected(boolean systemProtected) { this.systemProtected = systemProtected; }

    public UUID getPrimaryBranchId() { return primaryBranchId; }
    public void setPrimaryBranchId(UUID primaryBranchId) { this.primaryBranchId = primaryBranchId; }

    public boolean isHasLocalPassword() { return hasLocalPassword; }
    public void setHasLocalPassword(boolean hasLocalPassword) { this.hasLocalPassword = hasLocalPassword; }
}
