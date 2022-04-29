import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="employeesAlt")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeAlt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeNumber")
    private Integer employeeNumber;

    @Column(name="fullName", length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name="department_id")
    private DepartmentAlt department;

    @ManyToOne
    @JoinColumn(name="office_id")
    private Office office;
}
