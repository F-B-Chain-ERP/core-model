package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = TableName.KDS_TICKET_ITEM)
public class KdsTicketItem extends BaseAuditingEntity {

    @Column(name = "status", nullable = false, length = 30)
    private String status = "QUEUED";

    @Column(name = "kds_ticket_id", nullable = false)
    private UUID kdsTicketId;

    @Column(name = "order_item_id", nullable = false)
    private UUID orderItemId;

    @Column(name = "prepared_quantity", nullable = false)
    private Integer preparedQuantity = 0;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getKdsTicketId() {
        return kdsTicketId;
    }

    public void setKdsTicketId(UUID kdsTicketId) {
        this.kdsTicketId = kdsTicketId;
    }

    public UUID getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(UUID orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getPreparedQuantity() {
        return preparedQuantity;
    }

    public void setPreparedQuantity(Integer preparedQuantity) {
        this.preparedQuantity = preparedQuantity;
    }
}
