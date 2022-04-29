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
@Table(name="cds")
public class CD extends Product {
    @Column(name="artist", nullable = false)
    private String artist;

    public CD(String artist, String name, String description){
        super(null, name,description);
        this.artist=artist;
    }
}
