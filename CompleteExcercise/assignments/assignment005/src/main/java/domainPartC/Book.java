package domainPartC;

import domainPartC.Product;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="books")
public class Book extends Product {
    @Column(name="title", nullable = false)
    private String title;

    public Book(String title, String name, String description){
        super(null, name,description);
        this.title=title;
    }
}
