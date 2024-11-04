package com.sn.onepay.usermanagermodel.dto.organization;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record OrganizationConfigurationDTO(
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @NotEmpty
        @NotNull
        Long amountMaxResto,

        @NotEmpty
        @NotNull
        Long amountMaxMarket,

        @NotEmpty
        @NotNull
        Long amountMaxGasStation,

        @NotEmpty
        @NotNull
        Long amountMaxTelephony,

        @NotEmpty
        @NotNull
        Long percentageOrganization,

        @NotEmpty
        @NotNull
        Long percentageEmployee,

        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        LocalDateTime creationDate,

        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        LocalDateTime modificationDate

) {
}
