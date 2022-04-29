import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="isbn", updatable = false, nullable = false)
    private Long isbn;


    @Column(name="title", length = 200, nullable = false)
    private String title;

    @Column(name="author", length = 200, nullable = false)
    private String author;

    @ManyToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;
}
