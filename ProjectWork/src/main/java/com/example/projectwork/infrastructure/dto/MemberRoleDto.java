package com.example.projectwork.infrastructure.dto;

import com.example.projectwork.domain.common.AuditableWithActive;
import lombok.Data;

@Data
public class MemberRoleDto {
    private long id;
    private String name;
    private String description;
    private AuditableWithActive auditable;
}
