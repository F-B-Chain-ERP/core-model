package com.erp.core.domain;

import com.erp.core.constants.TableName;
import com.erp.core.constants.Defaults;
import com.erp.core.enums.EntityStatus;
import com.erp.core.enums.PrincipalType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Địa chỉ giao hàng của khách hàng. Mỗi khách hàng có thể có nhiều địa chỉ,
 * tối đa một địa chỉ mặc định (is_default).
 */
@Entity
@Table(name = TableName.CUSTOMER_ADDRESS)
public class CustomerAddress extends BaseAuditingEntity {

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "receiver_name", nullable = false, length = 150)
    private String receiverName;

    @Column(name = "receiver_phone", nullable = false, length = 20)
    private String receiverPhone;

    @Column(name = "address_line", nullable = false, length = 255)
    private String addressLine;

    @Column(name = "ward", length = 100)
    private String ward;

    @Column(name = "district", length = 100)
    private String district;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "is_default", nullable = false)
    private boolean isDefault = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private EntityStatus status = Defaults.DEFAULT_STATUS;

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }
}
