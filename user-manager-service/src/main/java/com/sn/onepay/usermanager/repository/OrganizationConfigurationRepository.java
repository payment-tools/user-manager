package com.sn.onepay.usermanager.repository;

import com.sn.onepay.usermanager.entity.OrganizationConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationConfigurationRepository extends JpaRepository<OrganizationConfiguration, Long>, QuerydslPredicateExecutor<OrganizationConfiguration> {
}
