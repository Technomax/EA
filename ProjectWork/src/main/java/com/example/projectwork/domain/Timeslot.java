package com.example.projectwork.domain;

import com.example.projectwork.domain.common.AuditableWithActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="timeslots")
public class Timeslot {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="fromTime",  nullable = false)
    private LocalTime fromTime;
    @Column(name="toTime", nullable = false)
    private LocalTime toTime;
    @Embedded
    private AuditableWithActive auditable;
}
