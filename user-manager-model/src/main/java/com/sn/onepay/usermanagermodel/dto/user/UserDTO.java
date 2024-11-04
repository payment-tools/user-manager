package com.sn.onepay.usermanagermodel.dto.user;

import com.sn.onepay.usermanagermodel.dto.enumerations.UserStatus;
import com.sn.onepay.usermanagermodel.dto.organization.OrganizationDTO;
import com.sn.onepay.usermanagermodel.dto.role.RoleDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.NonNull;

import java.time.LocalDateTime;


public record UserDTO(
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @NonNull
        @NotEmpty
        String firstName,

        @NonNull
        @NotEmpty
        String lastName,

        @NonNull
        @NotEmpty
        String userName,

        @NonNull
        @NotEmpty
        @Email
        String email,

        @NonNull
        @NotEmpty
        String phoneNumber,

        UserStatus userStatus,

        OrganizationDTO organization,

        RoleDTO role,

        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        LocalDateTime creationDate,

        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        LocalDateTime modificationDate
) {
}
