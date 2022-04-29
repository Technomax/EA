import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="booksAlt")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookAlt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="isbn", updatable = false, nullable = false)
    private Long isbn;


    @Column(name="title", length = 200, nullable = false)
    private String title;

    @Column(name="author", length = 200, nullable = false)
    private String author;

    @OneToMany
    @JoinColumn(name="reservation_id")
    private List<ReservationAlt> reservations=new ArrayList<>();

    public BookAlt(String title, String author) {
        this.title=title;
        this.author=author;
    }
}
