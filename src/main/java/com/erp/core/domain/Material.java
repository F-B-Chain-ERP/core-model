package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = TableName.MATERIAL)
public class Material extends BaseAuditingEntity {

    @Column(name = "category_id", nullable = false)
    private UUID categoryId;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "base_unit_id", nullable = false)
    private UUID baseUnitId;

    @Column(name = "min_stock_alert", nullable = false, precision = 14, scale = 3)
    private BigDecimal minStockAlert = BigDecimal.ZERO;

    @Column(name = "shelf_life_days")
    private Integer shelfLifeDays;

    @Column(name = "is_perishable", nullable = false)
    private boolean isPerishable = false;

    @Column(name = "status", nullable = false, length = 30)
    private String status = "ACTIVE";

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getBaseUnitId() {
        return baseUnitId;
    }

    public void setBaseUnitId(UUID baseUnitId) {
        this.baseUnitId = baseUnitId;
    }

    public BigDecimal getMinStockAlert() {
        return minStockAlert;
    }

    public void setMinStockAlert(BigDecimal minStockAlert) {
        this.minStockAlert = minStockAlert;
    }

    public Integer getShelfLifeDays() {
        return shelfLifeDays;
    }

    public void setShelfLifeDays(Integer shelfLifeDays) {
        this.shelfLifeDays = shelfLifeDays;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
