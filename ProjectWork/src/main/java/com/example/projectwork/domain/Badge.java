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
@Table(name="badges")
public class Badge {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="textCode", length = 6, nullable = false)
    private String textCode;
    @Lob
    @Column(name="qrcode", nullable = true)
    private Blob qrCode;
    @OneToMany
    @JoinColumn(name="badge_id")
    private Set<Transaction> transaction= new HashSet<>();
    @Embedded
    private AuditableWithActive auditable;
}
