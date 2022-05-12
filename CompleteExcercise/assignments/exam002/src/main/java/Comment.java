import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    @Column(name="Comment_ID")
    private Long id = null;
    @ManyToOne
    @JoinColumn(name = "user_USER_id")
    private User user;
    @ManyToOne
    private Item item;
    private String lastName;
    private String content;
}
