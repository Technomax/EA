import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


    @Column(name="firstName", length = 200, nullable = false)
    private String firstName;

    @Column(name="lastName", length = 200, nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(name="student_Course", joinColumns={@JoinColumn(name="student_id")},
            inverseJoinColumns = {@JoinColumn(name="course_id")})
    private List<Course> courses=new ArrayList<>();

    public Student(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }
}
