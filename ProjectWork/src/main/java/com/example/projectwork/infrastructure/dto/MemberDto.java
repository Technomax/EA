package com.example.projectwork.infrastructure.dto;

import com.example.projectwork.domain.Membership;
import com.example.projectwork.domain.Role;
import com.example.projectwork.domain.common.Address;
import com.example.projectwork.domain.common.AuditableWithActive;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class MemberDto {
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private Address address;
    private Set<Role> roles= new HashSet<>();
    private Set<Membership> memberships= new HashSet<>();
    private AuditableWithActive auditable;
}
