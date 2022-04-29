import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="studentId", updatable = false, nullable = false)
    private Long studentId;

    @Column(name="firstName", length = 100, nullable = false)
    private String firstName;

    @Column(name="lastName", length = 100)
    private String lastName;

}
