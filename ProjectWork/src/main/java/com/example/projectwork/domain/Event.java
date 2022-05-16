package com.example.projectwork.domain;

import com.example.projectwork.domain.common.AuditableWithActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @OneToMany
    @JoinColumn(name="event_id")
    private Set<Transaction> transactions= new HashSet<>();
    @Embedded
    private AuditableWithActive auditable;
}
