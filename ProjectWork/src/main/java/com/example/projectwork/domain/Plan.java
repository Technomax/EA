package com.example.projectwork.domain;

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
@Table(name="plans")
public class Plan {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="name", length = 150, nullable = false)
    private String name;

    @Column(name="description", length = 1000, nullable = true)
    private String description;

    @ManyToMany
    @JoinTable(name="plan_role_links", joinColumns = {@JoinColumn(name="plan_id")},inverseJoinColumns = {@JoinColumn(name="role_id")})
    private Set<Role> roles= new HashSet<>();

    @ManyToMany
    @JoinTable(name="plan_timeslot_links", joinColumns = {@JoinColumn(name="plan_id")},inverseJoinColumns = {@JoinColumn(name="timeslot_id")})
    private Set<Timeslot> timeslots= new HashSet<>();

    @OneToMany
    @JoinColumn(name="plan_id")
    private Set<Membership> memberships= new HashSet<>();

    @OneToMany
    @JoinColumn(name="plan_id")
    private Set<Event> events= new HashSet<>();

    @Embedded
    private AuditableWithActive auditable;
}
