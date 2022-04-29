import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeNumber")
    private Integer employeeNumber;

    @Column(name="fullName", length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
}
