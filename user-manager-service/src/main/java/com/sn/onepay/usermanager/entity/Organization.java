package com.sn.onepay.usermanager.entity;

import com.sn.onepay.usermanagermodel.dto.enumerations.EnrolledModule;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Organization")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "OrganizationGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "OrganizationId", allocationSize = 1)
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "OrganizationGen")
    @Column(name = "organizationId")
    Long id;

    @Column(name = "Name", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    String name;

    @Column(name = "Reference")
    @EqualsAndHashCode.Include
    String reference;

    @Column(name = "MaxQuota")
    @EqualsAndHashCode.Include
    Long maxQuota;

    @Column(name = "ActualQuota")
    @EqualsAndHashCode.Include
    Long actualQuota;

    @Column(name = "EnrolledModule")
    @EqualsAndHashCode.Include
    EnrolledModule enrolledModule;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "OrganizationConfigurationId", referencedColumnName = "OrganizationConfigurationId", nullable = false)
    OrganizationConfiguration organizationConfiguration;

    @CreatedDate
    @Column(name = "CreationDate", updatable = false, nullable = false)
    LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "ModificationDate", insertable = false)
    LocalDateTime modicationDate;
}
