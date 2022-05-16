package com.example.projectwork.infrastructure.dto;

import com.example.projectwork.domain.Event;
import com.example.projectwork.domain.Timeslot;
import com.example.projectwork.domain.common.Address;
import com.example.projectwork.domain.common.AuditableWithActive;
import com.example.projectwork.domain.common.LocationType;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class LocationDto {
    private long id;
    private String name;
    private String description;
    private Address address;
    private int capacity;
    private LocationType locationType;
    private Set<Event> events= new HashSet<>();
    private Set<Timeslot> timeslots= new HashSet<>();
    private AuditableWithActive auditable;
}