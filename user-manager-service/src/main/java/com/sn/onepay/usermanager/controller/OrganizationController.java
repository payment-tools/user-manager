package com.sn.onepay.usermanager.controller;


import com.sn.onepay.usermanager.service.IOrganizationService;
import com.sn.onepay.usermanagermodel.dto.organization.OrganizationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Data
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/v1/organizations")
@Tag(name = "organizations", description = "organizations controllers")
public class OrganizationController {

    final IOrganizationService iOrganizationService;

    @Operation(summary = "Create organization", description = "Create Organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "success"),
            @ApiResponse(responseCode = "400", description = "Resource is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationDTO createOrganization(@Parameter(description = "organization to create") @RequestBody OrganizationDTO organizationDTO) {
        return iOrganizationService.createOrganization(organizationDTO);
    }

    @Operation(summary = "update organization", description = "update organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Resource is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @PutMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationDTO updateOrganization(
            @Parameter(description = "organization identifier", name = "organizationId", required = true ) @PathVariable Long organizationId,
            @Parameter(description = "organization dto") @RequestBody OrganizationDTO organizationDTO) {

        return iOrganizationService.updateOrganization(organizationId, organizationDTO);

    }

    @Operation(summary = "get organization by id", description = "Read organization by identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "organisation is not found for the given identifier"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @GetMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizationDTO getOrganizationById(@Parameter(description = "organization identifier", name = "organizationId") @PathVariable Long organizationId) {
        return iOrganizationService.getOrganizationById(organizationId);
    }

    @Operation(summary = "get organization by name", description = "Read organization by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "organisation is not found for the given name"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @GetMapping("/organizationName/{organizationName}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizationDTO getOrganizationByName(@Parameter(description = "organisation name", name = "organizationName") @PathVariable String organizationName) {

        return iOrganizationService.getOrganizationByName(organizationName);

    }

    @Operation(summary = "get organization by filter", description = "Read organization by filter params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "organisation is not found for the given name"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<OrganizationDTO> getOrganizationByFilters(
            @Parameter(description = "organisation identifier", name = "organisationId") @RequestParam(required = false)  Long organisationId,
            @Parameter(description = "organization name", name = "organisationName")  @RequestParam(required = false) String organisationName,
            Pageable pageable) {

        return iOrganizationService.getOrganizationsByFilters(organisationId, organisationName, pageable);

    }

    @Operation(summary = "delete organization by ID", description = "delete organization by identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "organisation is not found for the given id"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @DeleteMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoleById(@Parameter(description = "organization ID", name = "organizationId") @PathVariable Long organizationId) {
        iOrganizationService.deleteOrganization(organizationId);
    }
}
