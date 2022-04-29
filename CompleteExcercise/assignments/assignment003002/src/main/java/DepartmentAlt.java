import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departmentsAlt")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentAlt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;


    @Column(name="departmentName", length = 200)
    private String name;

    @OneToMany
    @JoinColumn(name="employee_id")
    private List<EmployeeAlt> employees=new ArrayList<>();

    public DepartmentAlt(String name) {
        this.name=name;
    }
}
