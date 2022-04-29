import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer year;
    private String model;
    private String maker;
    @ManyToMany
    @JoinTable(name="car_customer", joinColumns = {@JoinColumn(name="src_id")}, inverseJoinColumns = {@JoinColumn(name="dest_id")})
    private List<Customer> customers= new ArrayList();
}
