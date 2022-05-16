package com.example.projectwork.infrastructure.dto;

import com.example.projectwork.domain.common.Auditable;
import com.example.projectwork.domain.common.AuditableWithActive;
import lombok.Data;
import org.hibernate.Transaction;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

@Data
public class BadgeDto {
    private long id;
    private String textCode;
    private Blob qrCode;
    private Set<Transaction> transactions = new HashSet<>();
    private AuditableWithActive auditable;
}
