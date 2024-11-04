package com.sn.onepay.usermanager.service.impl;

import com.sn.onepay.usermanager.mapper.UserMapper;
import com.sn.onepay.usermanager.repository.UserRepository;
import com.sn.onepay.usermanager.service.IUserService;
import com.sn.onepay.usermanagermodel.dto.enumerations.UserStatus;
import com.sn.onepay.usermanagermodel.dto.user.UserDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService implements IUserService {

    final UserMapper userMapper;

    final UserRepository userRepository;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return null;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return null;
    }

    @Override
    public Page<UserDTO> getUsersByFilters(Long userId, String firstName, String lastName, String email, List<String> roles, Pageable pageable) {
        return null;
    }

    @Override
    public UserDTO disableOrEnableKeycloakUser(Long userId, UserStatus userStatus) {
        return null;
    }

    @Override
    public UserDTO readUserByKeycloakId(Long userId) {
        return null;
    }

    @Override
    public void deleteUserById(Long userId) {

    }

    @Override
    public void updatePassword(Long userId, String newPassword) {

    }
}
