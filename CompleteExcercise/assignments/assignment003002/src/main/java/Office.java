import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="offices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roomNumber")
    private Integer roomNumber;

    @Column(name="building", length = 100)
    private String building;

    @OneToMany
    @JoinColumn(name="employee_id")
    private List<EmployeeAlt> employees=new ArrayList<>();

    public Office(String building) {
        this.building=building;
    }
}
