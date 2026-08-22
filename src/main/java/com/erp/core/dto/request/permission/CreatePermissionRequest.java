package com.erp.core.dto.request.permission;

import com.erp.core.enums.EntityStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreatePermissionRequest(

        @NotBlank(message = "Permission code must not be blank")
        @Size(max = 120, message = "Permission code must not exceed 120 characters")
        @Pattern(
                regexp = "^[a-z][a-z0-9_]*(?::[a-z][a-z0-9_]*)+$",
                message = "Permission code must follow the format 'module:resource:action' in lowercase (e.g. pos:order:create)"
        )
        String code,

        @NotBlank(message = "Permission name must not be blank")
        @Size(max = 150, message = "Permission name must not exceed 150 characters")
        String name,

        @NotBlank(message = "Module must not be blank")
        @Size(max = 80, message = "Module must not exceed 80 characters")
        @Pattern(regexp = "^[A-Z][A-Z0-9_]*$", message = "Module must be uppercase letters, digits or underscore (e.g. SYS, POS)")
        String module,

        @Size(max = 255, message = "Description must not exceed 255 characters")
        String description,

        @NotNull(message = "Permission status must not be null")
        EntityStatus status
) {
}
