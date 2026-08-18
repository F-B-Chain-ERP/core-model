package com.erp.core.dto;

import com.erp.core.enums.AuthProvider;
import com.erp.core.enums.EntityStatus;
import java.time.Instant;

/**
 * Read-side projection of {@code IaAccount}.
 */
public class AccountResponse {

    private String id;
    private String username;
    private String email;
    private String fullName;
    private AuthProvider authProvider;
    private boolean hasLocalPassword;
    private EntityStatus status;
    private Instant lastLoginAt;
    private Instant createdAt;
    private Instant updatedAt;

    public AccountResponse() {
    }

    public AccountResponse(String id, String username, String email, String fullName,
                           AuthProvider authProvider, boolean hasLocalPassword, EntityStatus status,
                           Instant lastLoginAt, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.authProvider = authProvider;
        this.hasLocalPassword = hasLocalPassword;
        this.status = status;
        this.lastLoginAt = lastLoginAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public AuthProvider getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    public boolean isHasLocalPassword() {
        return hasLocalPassword;
    }

    public void setHasLocalPassword(boolean hasLocalPassword) {
        this.hasLocalPassword = hasLocalPassword;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
