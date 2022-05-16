package com.example.projectwork.domain;

import com.example.projectwork.domain.common.Address;
import com.example.projectwork.domain.common.AuditableWithActive;
import com.example.projectwork.domain.common.LocationType;
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
@Table(name="locations")
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="name", length = 150, nullable = false)
    private String name;

    @Column(name="description", length = 1000,nullable = true)
    private String description;

    @Embedded
    private Address address;

    @Column(name="capacity", nullable = false)
    private int capacity;

    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    @OneToMany
    @JoinColumn(name="location_id")
    private Set<Event> events= new HashSet<>();

    @OneToMany
    @JoinColumn(name="location_id")
    private Set<Timeslot> timeslots= new HashSet<>();

    @Embedded
    private AuditableWithActive auditable;
}
