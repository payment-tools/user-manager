package com.sn.onepay.usermanagermodel.dto.role;

import com.sn.onepay.usermanagermodel.dto.enumerations.RoleStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Collection;

public record RoleDTO(
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @NotBlank(message = "Your role needs a name")
        @Size(min = 3, max = 100)
        RoleStatus name,

        @NotBlank(message = "Your must have a description")
        @Size(min = 3, max = 100)
        String description,

        String externalReference,

        Collection<String> Permission,

        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        LocalDateTime creationDate,

        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        LocalDateTime modificationDate
) {
}
