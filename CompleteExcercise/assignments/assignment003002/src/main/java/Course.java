import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;


    @Column(name="courseNumber", length = 200, nullable = false)
    private String courseNumber;

    @Column(name="courseName", length = 200, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students= new ArrayList<>();

    public Course(String courseNumber, String name) {
        this.courseNumber=courseNumber;
        this.name=name;

    }
}
