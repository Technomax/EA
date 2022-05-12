import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "User_ID")
    private Long id = null;
    private int version = 0;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "RANK")
    private int ranking = 0;
    @Column(name = "IS_ADMIN")
    private boolean admin = false;
    @OneToMany(mappedBy = "user")
    List<Comment> comments;
    @OneToMany
    @JoinColumn(name = "user_id")
    List<Address> addresses;
}
