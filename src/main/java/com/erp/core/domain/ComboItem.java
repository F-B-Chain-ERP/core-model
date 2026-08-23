package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = TableName.COMBO_ITEM)
public class ComboItem extends BaseAuditingEntity {

    @Column(name = "status", nullable = false, length = 30)
    private String status = "ACTIVE";

    @Column(name = "combo_product_id", nullable = false)
    private UUID comboProductId;

    @Column(name = "variant_id", nullable = false)
    private UUID variantId;

    @Column(name = "quantity", nullable = false)
    private int quantity = 1;

    @Column(name = "is_substitutable", nullable = false)
    private boolean isSubstitutable = false;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getComboProductId() {
        return comboProductId;
    }

    public void setComboProductId(UUID comboProductId) {
        this.comboProductId = comboProductId;
    }

    public UUID getVariantId() {
        return variantId;
    }

    public void setVariantId(UUID variantId) {
        this.variantId = variantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSubstitutable() {
        return isSubstitutable;
    }

    public void setSubstitutable(boolean substitutable) {
        isSubstitutable = substitutable;
    }
}
