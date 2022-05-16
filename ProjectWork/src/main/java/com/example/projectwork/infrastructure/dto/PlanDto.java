package com.example.projectwork.infrastructure.dto;

import com.example.projectwork.domain.Event;
import com.example.projectwork.domain.Membership;
import com.example.projectwork.domain.Role;
import com.example.projectwork.domain.Timeslot;
import com.example.projectwork.domain.common.Auditable;
import com.example.projectwork.domain.common.AuditableWithActive;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PlanDto {
    private long id;
    private String name;
    private String description;
    private Set<Role> roles= new HashSet<>();
    private Set<Timeslot> timeslots= new HashSet<>();
    private Set<Membership> memberships= new HashSet<>();
    private Set<Event> events= new HashSet<>();
    private AuditableWithActive auditable;
}
