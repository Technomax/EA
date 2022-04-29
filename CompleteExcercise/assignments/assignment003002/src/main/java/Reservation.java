import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="reservations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;


    @Column(name="date",  nullable = false)
    private LocalDate date;


}
