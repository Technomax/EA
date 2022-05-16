package com.example.projectwork.domain;

import com.example.projectwork.domain.common.Address;
import com.example.projectwork.domain.common.AuditableWithActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="members")
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="firstName", length = 150, nullable = false)
    private String firstName;

    @Column(name="lastName", length = 150, nullable = false)
    private String lastName;

    @Column(name="email", length = 150, nullable = false)
    private String emailAddress;

    @Column(name="phone", length = 150, nullable = false)
    private String phoneNumber;

    @Embedded
    private Address address;

    @ManyToMany
    @JoinTable(name="member_role_links", joinColumns = {@JoinColumn(name="member_id")},inverseJoinColumns = {@JoinColumn(name="role_id")})
    private Set<Role> roles= new HashSet<>();

    @OneToMany
    @JoinColumn(name="member_id")
    private Set<Membership> memberships= new HashSet<>();

    @Embedded
    private AuditableWithActive auditable;
}
