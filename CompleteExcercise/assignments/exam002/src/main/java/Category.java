import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue
    private Long id = null;
     private int version = 0;
    private String name;
    @ManyToMany
    private List<Item> items;
}
