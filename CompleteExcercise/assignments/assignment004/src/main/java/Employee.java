import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @Column(name="id", updatable = false, nullable = false)
    private Long id;

    @Column(name="firstName", length = 100, nullable = false)
    private String firstName;

    @Column(name="lastName", length = 100)
    private String lastName;

    @OneToMany (mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Laptop> laptops= new HashSet();

    public Employee(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }
}
