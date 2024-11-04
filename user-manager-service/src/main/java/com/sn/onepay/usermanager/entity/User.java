package com.sn.onepay.usermanager.entity;

import com.sn.onepay.usermanagermodel.dto.enumerations.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "UserGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "UserId", allocationSize = 1)
public class User {

    @Id
    @Column(name = "UserId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "UserGen")
    Long userId;

    @Column(name = "FirstName")
    @EqualsAndHashCode.Include
    String firstName;

    @Column(name = "LastName")
    @EqualsAndHashCode.Include
    String lastName;

    @Column(name = "UserName")
    @EqualsAndHashCode.Include
    String username;

    @Column(name = "Email")
    @EqualsAndHashCode.Include
    String email;

    @Column(name = "PhoneNumber")
    @EqualsAndHashCode.Include
    String phoneNumber;

    @Column(name = "UserStatus")
    @EqualsAndHashCode.Include
    UserStatus userStatus;

    @ManyToOne
    @JoinColumn(name = "OrganizationId", nullable = false)
    Organization organization;

    @ManyToOne
    @JoinColumn(name = "RoleId", nullable = false)
    Role role;

    @CreatedDate
    @Column(name = "CreationDate", updatable = false, nullable = false)
    LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "ModificationDate", insertable = false)
    LocalDateTime modicationDate;

}
