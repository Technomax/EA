import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student extends Person {
    private LocalDate entry;
    @OneToMany(mappedBy = "student")
    @OrderColumn(name="sequence")
    private List<Grade> grades = new ArrayList<>();
}
