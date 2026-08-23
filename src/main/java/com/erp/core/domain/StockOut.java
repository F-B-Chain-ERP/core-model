package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = TableName.STOCK_OUT)
public class StockOut extends BaseAuditingEntity {

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "warehouse_id", nullable = false)
    private UUID warehouseId;

    @Column(name = "destination_type", nullable = false, length = 30)
    private String destinationType;

    @Column(name = "destination_reference_id")
    private UUID destinationReferenceId;

    @Column(name = "out_date", nullable = false)
    private LocalDate outDate;

    @Column(name = "note", length = 500)
    private String note;

    @Column(name = "status", nullable = false, length = 30)
    private String status = "DRAFT";

    @Column(name = "issued_by")
    private UUID issuedBy;

    @Column(name = "posted_at")
    private Instant postedAt;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UUID getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(UUID warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(String destinationType) {
        this.destinationType = destinationType;
    }

    public UUID getDestinationReferenceId() {
        return destinationReferenceId;
    }

    public void setDestinationReferenceId(UUID destinationReferenceId) {
        this.destinationReferenceId = destinationReferenceId;
    }

    public LocalDate getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDate outDate) {
        this.outDate = outDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(UUID issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Instant getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Instant postedAt) {
        this.postedAt = postedAt;
    }
}
