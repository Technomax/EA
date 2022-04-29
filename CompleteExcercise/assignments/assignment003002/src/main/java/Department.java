import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="departments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;


    @Column(name="departmentName", length = 200)
    private String name;

    @OneToMany
    @JoinColumn(name="employee_id")
    private List<Employee> employees=new ArrayList<>();

    public Department(String name) {
        this.name=name;
    }
}
