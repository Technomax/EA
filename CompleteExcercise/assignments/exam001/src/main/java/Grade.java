import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id
    @GeneratedValue
    private Integer id;
    private Double grade;
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
}
