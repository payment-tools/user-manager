package com.sn.onepay.usermanager.mapper;

import com.sn.onepay.usermanager.common.mapper.IMapper;
import com.sn.onepay.usermanager.entity.Role;
import com.sn.onepay.usermanagermodel.dto.role.RoleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RoleMapper extends IMapper<Role, RoleDTO> {
}
