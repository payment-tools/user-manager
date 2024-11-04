package com.sn.onepay.usermanagermodel.dto.organization;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record OrganizationDTO(
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @NotEmpty
        @NotBlank
        String name,

        String reference,

        @NotEmpty
        Long maxQuota,

        @NotEmpty
        Long actualQuota,

        OrganizationConfigurationDTO organizationConfiguration,

        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        LocalDateTime creationDate,

        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        LocalDateTime modificationDate
) {
}
