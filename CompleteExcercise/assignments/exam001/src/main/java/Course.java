import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    // Maximum of 3 characters (e.g. “544”), required field
    @Column(length = 3, nullable = false)
    private String code;

    // Maximum of 50 characters, required field
    @Column(length = 50, nullable = false)
    private String name;

    // Set of pre-requisite courses for this course. Can be empty.
    @OneToMany
    @JoinTable(name="course_course",
            joinColumns={@JoinColumn(name="course_id")},
            inverseJoinColumns = {@JoinColumn(name="preRequisites_id")})
    private Set<Course> preRequisites = new HashSet<>();
}