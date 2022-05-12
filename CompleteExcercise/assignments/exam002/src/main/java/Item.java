import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "Item_ID")
    private Long id = null;
    private String name;
    private String description;
    private BigDecimal reservePrice;
    @ManyToMany
    @JoinTable(name = "category_items",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private Set<Category> categories= new HashSet<>();
    @OneToMany (mappedBy = "item")
    @JoinTable(name = "comment_item",
            joinColumns = {@JoinColumn(name = "item")},
            inverseJoinColumns = {@JoinColumn(name = "comment")})
    List<Comment> comments;
}
