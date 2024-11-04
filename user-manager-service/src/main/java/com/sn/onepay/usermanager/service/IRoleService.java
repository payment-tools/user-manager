package com.sn.onepay.usermanager.service;

import com.sn.onepay.usermanagermodel.dto.enumerations.RoleStatus;
import com.sn.onepay.usermanagermodel.dto.role.RoleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface IRoleService {

    RoleDTO createRole(RoleDTO role);

    RoleDTO updateRole(Long roleId, RoleDTO role);

    RoleDTO getRoleById(Long roleId);

    RoleDTO getRoleByName(String roleName);

    Page<RoleDTO> getRolesByFilters(Long roleId, RoleStatus roleStatus, Pageable pageable);

    void deleteRoleById(Long roleId);

    Collection<String> getPermissionsByRoleName(String roleName);

    RoleDTO addPermission(String roleName, String permission);

    RoleDTO removePermission(String roleName, String permission);

    List<RoleDTO> getPermissionByRoleName(String roleName);
}
