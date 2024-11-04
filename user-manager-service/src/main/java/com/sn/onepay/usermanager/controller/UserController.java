package com.sn.onepay.usermanager.controller;


import com.sn.onepay.usermanager.service.IUserService;
import com.sn.onepay.usermanagermodel.dto.enumerations.UserStatus;
import com.sn.onepay.usermanagermodel.dto.user.UserDTO;
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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@Data
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/v1/users")
@Tag(name = "users", description = "users controllers")
public class UserController {

    final IUserService iUserService;

    @Operation(summary = "Create user", description = "Create user in the user manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "success"),
            @ApiResponse(responseCode = "400", description = "Resource is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Parameter(description = "organization to create") @RequestBody UserDTO userDTO) {
        return iUserService.createUser(userDTO);
    }

    @Operation(summary = "update user", description = "Update user in the user manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Resource is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO updateUser(
            @Parameter(description = "user identifiant", name = "userId", required = true ) @PathVariable Long userId,
            @Parameter(description = "user dto") @RequestBody UserDTO userDTO) {

        return iUserService.updateUser(userId, userDTO);

    }

    @Operation(summary = "get user by id", description = "Read user in the user manager by identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "user is not found for the given identifiant"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@Parameter(description = "user identifiant", name = "userId") @PathVariable Long userId) {
        return iUserService.getUserById(userId);
    }

    @Operation(summary = "get user by name", description = "Read user in the user manager by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "user is not found for the given name"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @GetMapping("/userName/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserByName(@Parameter(description = "user name", name = "userName") @PathVariable String userName) {

        return iUserService.getUserByUsername(userName);

    }

    @Operation(summary = "get user by filter", description = "Read user in the user manager by filter params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "user is not found for the given name"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<UserDTO> getUserByFilters(
            @Parameter(description = "user identifiant", name = "userId") @RequestParam(required = false)  Long userId,
            @Parameter(description = "user name", name = "firstName")  @RequestParam(required = false) String firstName,
            @Parameter(description = "user name", name = "lastName")  @RequestParam(required = false) String lastName,
            @Parameter(description = "user name", name = "email")  @RequestParam(required = false) String email,
            @Parameter(description = "user name", name = "email")  @RequestParam(required = false) List<String> roles,
            Pageable pageable) {

        return iUserService.getUsersByFilters( userId, firstName, lastName,  email, roles, pageable);

    }

    @Operation(summary = "delete user by ID", description = "Delete user in the user manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "user is not found for the given id"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@Parameter(description = "user ID", name = "userId") @PathVariable Long userId) {
        iUserService.deleteUserById(userId);
    }

    @Operation(summary = "enable or disable user", description = "Disable or Enable user in the user manager by identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Resource is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @PatchMapping("/status/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO disableOrEnableKeycloakUser(
            @Parameter(description = "user identified", name = "userId", required = true ) @PathVariable Long userId,
            @Parameter(description = "user dto") @RequestParam UserStatus userStatus) {

        return iUserService.disableOrEnableKeycloakUser(userId, userStatus);

    }

    @Operation(summary = "get user by keycloak id", description = "Read user in the user manager by keycloak indentifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "user is not found for the given identified"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @GetMapping("/keycloak/{userKeycloakId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO readUserByKeycloakId(@Parameter(description = "user identified", name = "userKeycloakId") @PathVariable Long userKeycloakId) {
        return iUserService.readUserByKeycloakId(userKeycloakId);
    }

    @Operation(summary = "enable or disable user", description = "Update password user in the user manager by identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Resource is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error during processing")
    })
    @PatchMapping("/password/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updatePassword(
            @Parameter(description = "user identified", name = "userId", required = true ) @PathVariable Long userId,
            @Parameter(description = "new password", name = "newPassword") @RequestParam String newPassword) {

        iUserService.updatePassword(userId, newPassword);

    }
}
