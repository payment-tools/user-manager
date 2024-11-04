package com.sn.onepay.usermanager.service.impl;

import com.sn.onepay.usermanager.mapper.RoleMapper;
import com.sn.onepay.usermanager.repository.RoleRepository;
import com.sn.onepay.usermanager.service.IRoleService;
import com.sn.onepay.usermanagermodel.dto.enumerations.RoleStatus;
import com.sn.onepay.usermanagermodel.dto.role.RoleDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
@Transactional
public class RoleService implements IRoleService {

    final RoleRepository roleRepository;

    final RoleMapper roleMapper;


    @Override
    public RoleDTO createRole(RoleDTO role) {
        return null;
    }

    @Override
    public RoleDTO updateRole(Long roleId, RoleDTO role) {
        return null;
    }

    @Override
    public RoleDTO getRoleById(Long roleId) {
        return null;
    }

    @Override
    public RoleDTO getRoleByName(String roleName) {
        return null;
    }

    @Override
    public Page<RoleDTO> getRolesByFilters(Long roleId, RoleStatus roleStatus, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteRoleById(Long roleId) {

    }

    @Override
    public Collection<String> getPermissionsByRoleName(String roleName) {
        return List.of();
    }

    @Override
    public RoleDTO addPermission(String roleName, String permission) {
        return null;
    }

    @Override
    public RoleDTO removePermission(String roleName, String permission) {
        return null;
    }

    @Override
    public List<RoleDTO> getPermissionByRoleName(String roleName) {
        return List.of();
    }
}
