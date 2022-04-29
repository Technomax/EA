import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customersAlt")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerAlt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;


    @Column(name="name", length = 200, nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name="reservation_id")
    private List<ReservationAlt> reservations=new ArrayList<>();

    public CustomerAlt(String name) {
        this.name=name;
    }
}
