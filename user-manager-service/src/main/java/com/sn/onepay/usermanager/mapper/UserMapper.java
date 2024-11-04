package com.sn.onepay.usermanager.mapper;

import com.sn.onepay.usermanager.common.mapper.IMapper;
import com.sn.onepay.usermanager.entity.User;
import com.sn.onepay.usermanagermodel.dto.user.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends IMapper<User, UserDTO> {
}
