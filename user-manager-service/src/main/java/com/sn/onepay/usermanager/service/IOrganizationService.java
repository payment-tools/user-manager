package com.sn.onepay.usermanager.service;

import com.sn.onepay.usermanagermodel.dto.organization.OrganizationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrganizationService {

    OrganizationDTO createOrganization(OrganizationDTO organizationDTO);

    OrganizationDTO updateOrganization(Long organizationId, OrganizationDTO organizationDTO);

    OrganizationDTO getOrganizationById(Long organizationId);

    OrganizationDTO getOrganizationByName(String organizationName);

    Page<OrganizationDTO> getOrganizationsByFilters(Long id, String organisationName, Pageable pageable);

    void deleteOrganization(Long organizationId);
}
