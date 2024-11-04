package com.sn.onepay.usermanager.service;

import com.sn.onepay.usermanagermodel.dto.enumerations.UserStatus;
import com.sn.onepay.usermanagermodel.dto.user.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long userId, UserDTO userDTO);

    UserDTO getUserById(Long userId);

    UserDTO getUserByUsername(String username);

    Page<UserDTO> getUsersByFilters(Long userId, String firstName, String lastName, String email, List<String> roles, Pageable pageable);

    UserDTO disableOrEnableKeycloakUser(Long userId, UserStatus userStatus);

    UserDTO readUserByKeycloakId(Long userKeycloakId);

    void deleteUserById(Long userId);

    void updatePassword(Long userId, String newPassword);

}
