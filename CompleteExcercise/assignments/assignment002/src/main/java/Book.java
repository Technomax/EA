import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name="BookTitle", length = 500, nullable = false)
    private String title;
    @Column(name="ISBNNumber", length = 500, nullable = false, unique = true)
    private String ISBN;
    private String author;
    private double price;
    private java.util.Date publish_date;
}
