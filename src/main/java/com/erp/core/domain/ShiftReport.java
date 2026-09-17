package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
  * Thực thể biên bản báo cáo chốt ca và kiểm két tiền mặt tại điểm bán.
  */
@Entity
@Table(name = TableName.SHIFT_REPORT)
public class ShiftReport extends BaseAuditingEntity {

    @Column(name = "assignment_id", nullable = false, unique = true)
    private UUID assignmentId;

    @Column(name = "branch_id", nullable = false)
    private UUID branchId;

    @Column(name = "business_date", nullable = false)
    private LocalDate businessDate;

    @Column(name = "initial_cash", nullable = false, precision = 14, scale = 2)
    private BigDecimal initialCash = BigDecimal.ZERO;

    @Column(name = "cash_sales", nullable = false, precision = 14, scale = 2)
    private BigDecimal cashSales = BigDecimal.ZERO;

    @Column(name = "card_sales", nullable = false, precision = 14, scale = 2)
    private BigDecimal cardSales = BigDecimal.ZERO;

    @Column(name = "bank_transfer_sales", nullable = false, precision = 14, scale = 2)
    private BigDecimal bankTransferSales = BigDecimal.ZERO;

    @Column(name = "ewallet_sales", nullable = false, precision = 14, scale = 2)
    private BigDecimal ewalletSales = BigDecimal.ZERO;

    @Column(name = "total_sales", nullable = false, precision = 14, scale = 2)
    private BigDecimal totalSales = BigDecimal.ZERO;

    @Column(name = "orders_count", nullable = false)
    private Integer ordersCount = 0;

    @Column(name = "cash_payout", nullable = false, precision = 14, scale = 2)
    private BigDecimal cashPayout = BigDecimal.ZERO;

    @Column(name = "expected_cash", nullable = false, precision = 14, scale = 2)
    private BigDecimal expectedCash = BigDecimal.ZERO;

    @Column(name = "actual_cash", nullable = false, precision = 14, scale = 2)
    private BigDecimal actualCash = BigDecimal.ZERO;

    @Column(name = "difference", nullable = false, precision = 14, scale = 2)
    private BigDecimal difference = BigDecimal.ZERO;

    @Column(name = "difference_reason", length = 500)
    private String differenceReason;

    @Column(name = "cash_denominations", columnDefinition = "text")
    private String cashDenominations;

    @Column(name = "status", nullable = false, length = 30)
    private String status = "SUBMITTED";

    @Column(name = "submitted_by")
    private UUID submittedById;

    @Column(name = "submitted_at")
    private Instant submittedAt;

    @Column(name = "approved_by")
    private UUID approvedById;

    @Column(name = "approved_at")
    private Instant approvedAt;

    @Column(name = "note", length = 500)
    private String note;

    public UUID getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(UUID assignmentId) {
        this.assignmentId = assignmentId;
    }

    public UUID getBranchId() {
        return branchId;
    }

    public void setBranchId(UUID branchId) {
        this.branchId = branchId;
    }

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public BigDecimal getInitialCash() {
        return initialCash;
    }

    public void setInitialCash(BigDecimal initialCash) {
        this.initialCash = initialCash;
    }

    public BigDecimal getCashSales() {
        return cashSales;
    }

    public void setCashSales(BigDecimal cashSales) {
        this.cashSales = cashSales;
    }

    public BigDecimal getCardSales() {
        return cardSales;
    }

    public void setCardSales(BigDecimal cardSales) {
        this.cardSales = cardSales;
    }

    public BigDecimal getBankTransferSales() {
        return bankTransferSales;
    }

    public void setBankTransferSales(BigDecimal bankTransferSales) {
        this.bankTransferSales = bankTransferSales;
    }

    public BigDecimal getEwalletSales() {
        return ewalletSales;
    }

    public void setEwalletSales(BigDecimal ewalletSales) {
        this.ewalletSales = ewalletSales;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public Integer getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
    }

    public BigDecimal getCashPayout() {
        return cashPayout;
    }

    public void setCashPayout(BigDecimal cashPayout) {
        this.cashPayout = cashPayout;
    }

    public BigDecimal getExpectedCash() {
        return expectedCash;
    }

    public void setExpectedCash(BigDecimal expectedCash) {
        this.expectedCash = expectedCash;
    }

    public BigDecimal getActualCash() {
        return actualCash;
    }

    public void setActualCash(BigDecimal actualCash) {
        this.actualCash = actualCash;
    }

    public BigDecimal getDifference() {
        return difference;
    }

    public void setDifference(BigDecimal difference) {
        this.difference = difference;
    }

    public String getDifferenceReason() {
        return differenceReason;
    }

    public void setDifferenceReason(String differenceReason) {
        this.differenceReason = differenceReason;
    }

    public String getCashDenominations() {
        return cashDenominations;
    }

    public void setCashDenominations(String cashDenominations) {
        this.cashDenominations = cashDenominations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getSubmittedById() {
        return submittedById;
    }

    public void setSubmittedById(UUID submittedById) {
        this.submittedById = submittedById;
    }

    public Instant getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Instant submittedAt) {
        this.submittedAt = submittedAt;
    }

    public UUID getApprovedById() {
        return approvedById;
    }

    public void setApprovedById(UUID approvedById) {
        this.approvedById = approvedById;
    }

    public Instant getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Instant approvedAt) {
        this.approvedAt = approvedAt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
