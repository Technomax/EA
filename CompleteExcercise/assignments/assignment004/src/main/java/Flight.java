import lombok.*;
//https://thorben-janssen.com/hibernate-tips-map-bidirectional-many-one-association/
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="flights")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;

    @Column(name="flightNumber", length = 20, nullable = false)
    private String flightNumber;

    @Column(name="`from`", length = 200, nullable = false)
    private String from;

    @Column(name="`to`", length = 200, nullable = false)
    private String to;

    @Column(name="flightDate")
    private LocalDate date;
}
