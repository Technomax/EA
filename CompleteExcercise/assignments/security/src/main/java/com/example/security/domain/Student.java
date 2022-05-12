package com.example.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student")
public  class Student {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "fullName", length = 150, nullable = false)
    private String name;
    @Column(name = "gender", length = 10, nullable = false)
    private Gender gender;
    @Column(name = "maritalStatus", length = 10, nullable = false)
    private MaritalStatus maritalStatus;
    @Embedded
    private Address address;
    @Column(name = "contactNumber", length = 10, nullable = false)
    private String contactNumber;
    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> courses = new HashSet<>();
    @Embedded
    private Auditable auditable;
}
