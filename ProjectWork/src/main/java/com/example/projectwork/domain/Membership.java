package com.example.projectwork.domain;

import com.example.projectwork.domain.common.AuditableWithActive;
import com.example.projectwork.domain.common.RecurringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="startDate", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name="endDate", nullable = true)
    private LocalDateTime endDateTime;

    @Column(name="maxAllowedUsages", nullable = false)
    private int maxAllowedUsages;

    @Column(name="recurringType", nullable = false)
    private RecurringType recurringType;

    @Column(name="nextRenewalDate", nullable = true)
    private LocalDate nextRenewalDate;

    @Column(name="remainingUsage", nullable = true)
    private int remainingUsages;

    @Embedded
    private AuditableWithActive auditable;
}
