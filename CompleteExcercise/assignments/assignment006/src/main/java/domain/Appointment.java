package domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name="appointments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="APPDATE")
    private LocalDate appDate;

    @ManyToOne
    @JoinColumn(name = "PATIENT")
    private Patient patient;

    @Embedded
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "DOCTOR")
    private Doctor doctor;
}
