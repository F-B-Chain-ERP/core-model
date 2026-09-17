package com.erp.core.dto.request.pos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateOrderRequest(
    @NotNull UUID branchId,
    @NotBlank @Pattern(regexp = "PICKUP|DELIVERY") String orderType,
    @Size(max = 100) String voucherCode,
    @NotBlank @Size(max = 150) String receiverName,
    @NotBlank @Size(max = 20) @Pattern(regexp = "^[0-9+() .-]{8,20}$") String receiverPhone,
    @Size(max = 255) String shippingAddress,
    @NotBlank @Pattern(regexp = "CASH|COD|VNPAY|MOMO|BANK_TRANSFER") String paymentMethod,
    @Size(max = 500) String note,
    UUID pickupTimeSlotId,
    String sessionToken
) {
}
