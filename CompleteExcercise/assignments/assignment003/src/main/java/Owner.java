import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Owner {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true, length=500)
    private String address;

    @OneToMany
    @JoinColumn(name="owner_id")
    private List<Car> cars= new ArrayList<>();
}
