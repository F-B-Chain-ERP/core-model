package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = TableName.STOCK_TRANSFER)
public class StockTransfer extends BaseAuditingEntity {

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "from_warehouse_id", nullable = false)
    private UUID fromWarehouseId;

    @Column(name = "to_warehouse_id", nullable = false)
    private UUID toWarehouseId;

    @Column(name = "transfer_date", nullable = false)
    private LocalDate transferDate;

    @Column(name = "status", nullable = false, length = 30)
    private String status = "PENDING";

    @Column(name = "note", length = 500)
    private String note;

    /** Người tạo yêu cầu (phe quán). */
    @Column(name = "requested_by")
    private UUID requestedBy;

    /** Người duyệt yêu cầu (phe kho, được trùng người xuất). */
    @Column(name = "approved_by")
    private UUID approvedBy;

    @Column(name = "approved_at")
    private Instant approvedAt;

    /** Người bấm xuất kho (phe kho). */
    @Column(name = "dispatched_by")
    private UUID dispatchedBy;

    @Column(name = "dispatched_at")
    private Instant dispatchedAt;

    @Column(name = "received_by")
    private UUID receivedBy;

    @Column(name = "received_at")
    private Instant receivedAt;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UUID getFromWarehouseId() {
        return fromWarehouseId;
    }

    public void setFromWarehouseId(UUID fromWarehouseId) {
        this.fromWarehouseId = fromWarehouseId;
    }

    public UUID getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(UUID toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UUID getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(UUID requestedBy) {
        this.requestedBy = requestedBy;
    }

    public UUID getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(UUID approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Instant getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Instant approvedAt) {
        this.approvedAt = approvedAt;
    }

    public UUID getDispatchedBy() {
        return dispatchedBy;
    }

    public void setDispatchedBy(UUID dispatchedBy) {
        this.dispatchedBy = dispatchedBy;
    }

    public Instant getDispatchedAt() {
        return dispatchedAt;
    }

    public void setDispatchedAt(Instant dispatchedAt) {
        this.dispatchedAt = dispatchedAt;
    }

    public UUID getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(UUID receivedBy) {
        this.receivedBy = receivedBy;
    }

    public Instant getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Instant receivedAt) {
        this.receivedAt = receivedAt;
    }
}
