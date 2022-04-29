package domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name="patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SecondaryTables(
        @SecondaryTable(name="addresses",pkJoinColumns = {
                @PrimaryKeyJoinColumn(name="PATIENT_ID",referencedColumnName = "id")
        })
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="STREET", table = "addresses")
    private String street;

    @Column(name="ZIP", table = "addresses")
    private String zip;

    @Column(name="CITY", table = "addresses")
    private String city;
}
