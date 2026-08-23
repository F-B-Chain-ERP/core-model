package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = TableName.PRODUCT_TOPPING)
public class ProductTopping extends BaseAuditingEntity {

    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column(name = "topping_id", nullable = false)
    private UUID toppingId;

    @Column(name = "is_default", nullable = false)
    private boolean isDefault = false;

    @Column(name = "max_quantity", nullable = false)
    private int maxQuantity = 3;

    @Column(name = "status", nullable = false, length = 30)
    private String status = "ACTIVE";

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public UUID getToppingId() {
        return toppingId;
    }

    public void setToppingId(UUID toppingId) {
        this.toppingId = toppingId;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
