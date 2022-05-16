package com.example.projectwork.infrastructure.dto;

import com.example.projectwork.domain.common.AuditableWithActive;
import lombok.Data;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

@Data
public class EventDto {
    private long id;
    private Set<Transaction> transactions= new HashSet<>();
    private Boolean isActive;
    private AuditableWithActive auditable;
}
