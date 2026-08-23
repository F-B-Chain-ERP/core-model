package com.erp.core.domain;

import com.erp.core.constants.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Chi nhánh / đơn vị kinh doanh. Dùng cho bước chọn đơn vị sau đăng nhập
 * và làm phạm vi (scope) cho vai trò tài khoản nội bộ.
 */
@Entity
@Table(name = TableName.BRANCH)
public class Branch extends BaseAuditingEntity {

    @Column(name = "code", nullable = false, length = 50, unique = true)
    private String code;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "timezone", nullable = false, length = 50)
    private String timezone = "Asia/Ho_Chi_Minh";

    @Column(name = "supports_pickup", nullable = false)
    private boolean supportsPickup = true;

    @Column(name = "supports_delivery", nullable = false)
    private boolean supportsDelivery = false;

    @Column(name = "average_preparation_minutes", nullable = false)
    private int averagePreparationMinutes = 15;

    @Column(name = "status", nullable = false, length = 30)
    private String status = "ACTIVE";

    @Column(name = "parent_id")
    private UUID parentId;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public boolean isSupportsPickup() {
        return supportsPickup;
    }

    public void setSupportsPickup(boolean supportsPickup) {
        this.supportsPickup = supportsPickup;
    }

    public boolean isSupportsDelivery() {
        return supportsDelivery;
    }

    public void setSupportsDelivery(boolean supportsDelivery) {
        this.supportsDelivery = supportsDelivery;
    }

    public int getAveragePreparationMinutes() {
        return averagePreparationMinutes;
    }

    public void setAveragePreparationMinutes(int averagePreparationMinutes) {
        this.averagePreparationMinutes = averagePreparationMinutes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }
}
