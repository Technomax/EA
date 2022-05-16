package com.example.projectwork.domain;

import com.example.projectwork.domain.common.AuditableWithActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="name", length = 150, nullable = false)
    private String name;
    @Column(name="description", length = 150, nullable = false)
    private String description;
    @Embedded
    private AuditableWithActive auditable;
}
