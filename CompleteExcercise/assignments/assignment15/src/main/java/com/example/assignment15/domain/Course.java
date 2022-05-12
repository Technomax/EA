package com.example.assignment15.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String courseName;
    private String courseCode;
    private int totalCredit;
    @Embedded
    private Auditable auditable;
}
