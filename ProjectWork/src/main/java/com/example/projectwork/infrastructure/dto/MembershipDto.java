package com.example.projectwork.infrastructure.dto;

import com.example.projectwork.domain.common.AuditableWithActive;
import com.example.projectwork.domain.common.RecurringType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MembershipDto {
    private long id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int maxAllowedUsages;
    private RecurringType recurringType;
    private LocalDate nextRenewalDate;
    private int remainingUsages;
    private AuditableWithActive auditable;
}
