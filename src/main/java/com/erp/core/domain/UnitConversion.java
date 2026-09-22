package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Một chiều quy đổi giữa 2 đơn vị cùng nhóm (khối lượng / thể tích / đếm).
 * Chỉ seed 1 chiều (VD kg-&gt;g); chiều ngược code tự đảo (1/factor).
 * Quy đổi theo từng NVL (bao/thùng -&gt; đơn vị gốc) nằm ở {@link Material}.
 */
@Entity
@Table(name = TableName.UNIT_CONVERSION)
public class UnitConversion extends BaseAuditingEntity {

    @Column(name = "from_unit_id", nullable = false)
    private UUID fromUnitId;

    @Column(name = "to_unit_id", nullable = false)
    private UUID toUnitId;

    @Column(name = "factor", nullable = false, precision = 18, scale = 6)
    private BigDecimal factor;

    @Column(name = "status", nullable = false, length = 30)
    private String status = "ACTIVE";

    public UUID getFromUnitId() {
        return fromUnitId;
    }

    public void setFromUnitId(UUID fromUnitId) {
        this.fromUnitId = fromUnitId;
    }

    public UUID getToUnitId() {
        return toUnitId;
    }

    public void setToUnitId(UUID toUnitId) {
        this.toUnitId = toUnitId;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
