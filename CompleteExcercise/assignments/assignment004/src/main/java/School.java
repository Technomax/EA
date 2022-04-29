import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="schools")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "schoolName", length = 150, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name="studentId")
    private Map<Long,Student> students = new HashMap();

    public School(String name) {
        this.name=name;
    }
}
