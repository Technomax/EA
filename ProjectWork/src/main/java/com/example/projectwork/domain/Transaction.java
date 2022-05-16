package com.example.projectwork.domain;

import com.example.projectwork.domain.common.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="tranDate", nullable = false)
    private LocalDate tranDate;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @Embedded
    private Auditable auditable;
}
