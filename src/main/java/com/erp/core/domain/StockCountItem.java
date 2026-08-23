package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = TableName.STOCK_COUNT_ITEM)
public class StockCountItem extends BaseAuditingEntity {

    @Column(name = "status", nullable = false, length = 30)
    private String status = "ACTIVE";

    @Column(name = "stock_count_id", nullable = false)
    private UUID stockCountId;

    @Column(name = "material_id", nullable = false)
    private UUID materialId;

    @Column(name = "system_quantity", nullable = false, precision = 14, scale = 3)
    private BigDecimal systemQuantity;

    @Column(name = "counted_quantity", nullable = false, precision = 14, scale = 3)
    private BigDecimal countedQuantity;

    @Column(name = "variance_quantity", nullable = false, precision = 14, scale = 3)
    private BigDecimal varianceQuantity;

    @Column(name = "note", length = 255)
    private String note;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getStockCountId() {
        return stockCountId;
    }

    public void setStockCountId(UUID stockCountId) {
        this.stockCountId = stockCountId;
    }

    public UUID getMaterialId() {
        return materialId;
    }

    public void setMaterialId(UUID materialId) {
        this.materialId = materialId;
    }

    public BigDecimal getSystemQuantity() {
        return systemQuantity;
    }

    public void setSystemQuantity(BigDecimal systemQuantity) {
        this.systemQuantity = systemQuantity;
    }

    public BigDecimal getCountedQuantity() {
        return countedQuantity;
    }

    public void setCountedQuantity(BigDecimal countedQuantity) {
        this.countedQuantity = countedQuantity;
    }

    public BigDecimal getVarianceQuantity() {
        return varianceQuantity;
    }

    public void setVarianceQuantity(BigDecimal varianceQuantity) {
        this.varianceQuantity = varianceQuantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
