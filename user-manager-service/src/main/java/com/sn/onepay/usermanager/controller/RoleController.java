package com.sn.onepay.usermanager.controller;


import com.sn.onepay.usermanager.service.IRoleService;
import com.sn.onepay.usermanagermodel.dto.enumerations.RoleStatus;
import com.sn.onepay.usermanagermodel.dto.role.RoleDTO;
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
@RequestMapping("/v1/roles")
@Tag(name = "roles", description = "roles controllers")
public class RoleController {

    final IRoleService iRoleService;

    @Operation(summary = "Create role", description = "create role in the user manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "success"),
            @ApiResponse(responseCode = "400", description = "Resource is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO createRole(@Parameter(description = "role to create") @RequestBody RoleDTO roleDTO) {
        return iRoleService.createRole(roleDTO);
    }

    @Operation(summary = "update role", description = "Update role in the user manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Resource is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @PutMapping("/{roleId}")
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO updateRole(
            @Parameter(description = "role identifiant", name = "roleId", required = true ) @PathVariable Long roleId,
            @Parameter(description = "role dto") @RequestBody RoleDTO roleDTO) {

        return iRoleService.updateRole(roleId, roleDTO);

    }

    @Operation(summary = "get role by id", description = "Read role in the user manager by identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "organisation is not found for the given identifiant"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @GetMapping("/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDTO getRoleById(@Parameter(description = "role identifiant", name = "roleId") @PathVariable Long roleId) {
        return iRoleService.getRoleById(roleId);
    }

    @Operation(summary = "get role by name", description = "Read role in the user manager by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "organisation is not found for the given name"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @GetMapping("/roleName/{roleName}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDTO getRoleByName(@Parameter(description = "organisation name", name = "roleName") @PathVariable String roleName) {

        return iRoleService.getRoleByName(roleName);

    }

    @Operation(summary = "get role by filter", description = "Read role by filter in the user manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "organisation is not found for the given name"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<RoleDTO> getRoleByFilters(
            @Parameter(description = "organisation identifiant", name = "roleId") @RequestParam(required = false)  Long roleId,
            @Parameter(description = "role name", name = "roleName")  @RequestParam(required = false) RoleStatus roleName,
            Pageable pageable) {

        return iRoleService.getRolesByFilters(roleId, roleName, pageable);

    }

    @Operation(summary = "get role by filter", description = "Delete role in the user manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "organisation is not found for the given name"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @DeleteMapping("/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRoleById( @Parameter(description = "organisation identifiant", name = "roleId") @PathVariable Long roleId) {

        iRoleService.deleteRoleById(roleId);

    }
}
