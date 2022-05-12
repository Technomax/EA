import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@SecondaryTable( name="biography",pkJoinColumns=@PrimaryKeyJoinColumn(name="id"))
public class Faculty extends Person {

    //optional field with a maximum length of 2000 characters
    @Column(table = "biography", length = 2000, nullable = true)
    private String biography;

    @Column(table = "synopsys", length = 2000, nullable = true)
    private String synopsys;
    @OneToMany
    private Set<Course> courses = new HashSet<>();
}