package com.example.projectwork.infrastructure.dto;

import com.example.projectwork.domain.common.AuditableWithActive;
import lombok.Data;

import java.time.LocalTime;

@Data
public class TimeslotDto {
    private long id;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Boolean isActive;
    private AuditableWithActive auditable;
}
