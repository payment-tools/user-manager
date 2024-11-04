package com.sn.onepay.usermanager.mapper;

import com.sn.onepay.usermanager.common.mapper.IMapper;
import com.sn.onepay.usermanager.entity.Organization;
import com.sn.onepay.usermanagermodel.dto.organization.OrganizationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "srping", uses = {UserMapper.class})
public interface OrganizationMapper extends IMapper<Organization, OrganizationDTO> {
}
