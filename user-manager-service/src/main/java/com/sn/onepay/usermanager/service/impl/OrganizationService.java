package com.sn.onepay.usermanager.service.impl;

import com.sn.onepay.usermanager.service.IOrganizationService;
import com.sn.onepay.usermanagermodel.dto.organization.OrganizationDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrganizationService implements IOrganizationService {
    @Override
    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {
        return null;
    }

    @Override
    public OrganizationDTO updateOrganization(Long organizationId, OrganizationDTO organizationDTO) {
        return null;
    }

    @Override
    public OrganizationDTO getOrganizationById(Long organizationId) {
        return null;
    }

    @Override
    public OrganizationDTO getOrganizationByName(String organizationName) {
        return null;
    }

    @Override
    public Page<OrganizationDTO> getOrganizationsByFilters(Long id, String organisationName, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteOrganization(Long organizationId) {

    }
}
