import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;


    @Column(name="name", length = 200, nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name="reservation_id")
    private List<Reservation> reservations=new ArrayList<>();

    public Customer(String name) {
        this.name=name;
    }
}
