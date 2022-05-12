package com.example.securityclient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long id;
    private String courseName;
    private String courseCode;
    private int totalCredit;
    private Auditable auditable;
}
