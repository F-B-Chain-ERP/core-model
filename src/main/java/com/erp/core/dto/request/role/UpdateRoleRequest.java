package com.erp.core.dto.request.role;

import com.erp.core.enums.*;
import jakarta.validation.constraints.*;

public record UpdateRoleRequest(

        @NotBlank(message = "Role name must not be blank")
        @Size(max = 150, message = "Role name must not exceed 150 characters")
        String name,

        @Size(max = 255, message = "Description must not exceed 255 characters")
        String description,

        @NotNull(message = "Role type must not be null")
        RoleType type,

        @NotNull(message = "Role status must not be null")
        EntityStatus status
) {
}
