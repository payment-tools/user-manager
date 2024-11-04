package com.sn.onepay.usermanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "OrganizationConfiguration")
@TableGenerator(name = "OrganizationConfigurationGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "OrganizationConfigurationId", allocationSize = 1)
public class OrganizationConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "OrganizationConfigurationGen")
    @Column(name = "OrganizationConfigurationId", nullable = false, unique = true)
    Long id;

    @Column(name = "AmountMaxResto")
    @EqualsAndHashCode.Include
    Long amountMaxResto;

    @Column(name = "AmountMaxMarket")
    @EqualsAndHashCode.Include
    Long amountMaxMarket;

    @Column(name = "AmountMaxGasStation")
    @EqualsAndHashCode.Include
    Long amountMaxGasStation;

    @Column(name = "AmountMaxTelephony")
    @EqualsAndHashCode.Include
    Long amountMaxTelephony;

    @Column(name = "PercentageOrganization")
    @EqualsAndHashCode.Include
    Long percentageOrganization;

    @Column(name = "PercentageEmployee")
    @EqualsAndHashCode.Include
    Long percentageEmployee;

    @CreatedDate
    @Column(name = "CreationDate", updatable = false, nullable = false)
    LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "ModificationDate", insertable = false)
    LocalDateTime modicationDate;
}
