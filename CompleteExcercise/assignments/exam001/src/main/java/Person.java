import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private LocalDate birthday;
    @ElementCollection
    private List<String> hobbies = new ArrayList<>();
    @Embedded
    private Address address;

}
