package domainPartB;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="dvds")
public class DVD extends Product {
    @Column(name="genre", nullable = false)
    private String genre;

    public DVD(String genre, String name, String description){
        super(null, name,description);
        this.genre=genre;
    }
}
