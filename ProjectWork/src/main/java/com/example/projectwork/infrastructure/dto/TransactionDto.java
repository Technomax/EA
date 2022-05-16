package com.example.projectwork.infrastructure.dto;

import com.example.projectwork.domain.TransactionType;
import com.example.projectwork.domain.common.Auditable;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDto {
    private long id;
    private LocalDate tranDate;
    private TransactionType type;
    private Auditable auditable;
}
