package com.example.securityclientrest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public  class Student {
    private long id;
    private String name;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private Address address;
    private String contactNumber;
    private Set<Course> courses = new HashSet<>();
    private Auditable auditable;
}
