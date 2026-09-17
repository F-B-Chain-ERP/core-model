package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Entity tracking asynchronous report generation and export jobs.
 */
@Entity
@Table(name = TableName.REPORT_JOB)
public class ReportJob extends BaseAuditingEntity {

    @Column(name = "module", nullable = false, length = 30)
    private String module;

    @Column(name = "report_type", nullable = false, length = 50)
    private String reportType;

    @Column(name = "status", nullable = false, length = 20)
    private String status = "PENDING";

    @Column(name = "format", nullable = false, length = 10)
    private String format = "EXCEL";

    @Column(name = "requested_by", nullable = false)
    private UUID requestedBy;

    @Column(name = "branch_id")
    private UUID branchId;

    @Column(name = "request_params", columnDefinition = "text")
    private String requestParams;

    @Column(name = "estimated_rows")
    private Integer estimatedRows = 0;

    @Column(name = "file_url", columnDefinition = "text")
    private String fileUrl;

    @Column(name = "error_message", columnDefinition = "text")
    private String errorMessage;

    @Column(name = "started_at")
    private Instant startedAt;

    @Column(name = "completed_at")
    private Instant completedAt;

    public ReportJob() {
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public UUID getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(UUID requestedBy) {
        this.requestedBy = requestedBy;
    }

    public UUID getBranchId() {
        return branchId;
    }

    public void setBranchId(UUID branchId) {
        this.branchId = branchId;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public Integer getEstimatedRows() {
        return estimatedRows;
    }

    public void setEstimatedRows(Integer estimatedRows) {
        this.estimatedRows = estimatedRows;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Instant getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Instant startedAt) {
        this.startedAt = startedAt;
    }

    public Instant getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Instant completedAt) {
        this.completedAt = completedAt;
    }
}
