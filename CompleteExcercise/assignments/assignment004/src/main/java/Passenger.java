import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="passengers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;

    @Column(name="fullName", length = 150, nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name="passenger_id")
    private List<Flight> flights= new ArrayList<>();

    public Passenger(String name) {
        this.name=name;
    }
}
