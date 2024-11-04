package com.sn.onepay.usermanager.entity;

import com.sn.onepay.usermanagermodel.dto.enumerations.RoleStatus;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
import java.util.Collection;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Role")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "RoleGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "RoleId", allocationSize = 1)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "RoleGen")
    Long RoleId;

    @Column(name = "Name", nullable = false)
    @EqualsAndHashCode.Include
    RoleStatus name;

    @Column(name = "Description")
    @EqualsAndHashCode.Include
    String description;

    @Column(name = "ExternalReference")
    @EqualsAndHashCode.Include
    String externalReference;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = String.class)
    @JoinTable(name = "RolePermission", joinColumns = @JoinColumn(name = "RoleId"))
    @Column(name = "Permission", nullable = false)
    Collection<String> permission;

    @CreatedDate
    @Column(name = "CreationDate", updatable = false, nullable = false)
    LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "ModificationDate", insertable = false)
    LocalDateTime modicationDate;
}
