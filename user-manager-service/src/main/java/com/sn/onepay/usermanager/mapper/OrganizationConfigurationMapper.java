package com.sn.onepay.usermanager.mapper;

import com.sn.onepay.usermanager.common.mapper.IMapper;
import com.sn.onepay.usermanager.entity.OrganizationConfiguration;
import com.sn.onepay.usermanagermodel.dto.organization.OrganizationConfigurationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrganizationMapper.class})
public interface OrganizationConfigurationMapper extends IMapper<OrganizationConfiguration, OrganizationConfigurationDTO> {
}
