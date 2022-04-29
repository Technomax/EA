import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="publishers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;


    @Column(name="name", length = 200, nullable = false)
    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books=new ArrayList<>();

    public Publisher(String name) {
        this.name=name;
    }
}
