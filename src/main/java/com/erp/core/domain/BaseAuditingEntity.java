package com.erp.core.domain;

import com.erp.core.constants.Defaults;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import java.time.Instant;
import java.util.UUID;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Root mapped superclass for all core entities. Provides a UUID primary key
 * (char(36)), auditing timestamp columns populated via {@link AuditingEntityListener},
 * audit-by columns set manually by the application (no {@code AuditorAware} yet),
 * and a generic lifecycle {@code status}.
 *
 * <p>Auth reference tables and tenant business tables extend this directly or via
 * {@link BaseTenantEntity}.</p>
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseAuditingEntity {

    @Id
    @Column(columnDefinition = "char(36)", length = 36)
    private String id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "created_by", columnDefinition = "char(36)", length = 36)
    private String createdBy;

    @Column(name = "updated_by", columnDefinition = "char(36)", length = 36)
    private String updatedBy;

    @Column(name = "status", nullable = false, length = 20)
    private String status = Defaults.DEFAULT_STATUS.name();

    @PrePersist
    void prePersist() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
