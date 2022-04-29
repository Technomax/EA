import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="laptops")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;
    @Column(name="brand", length = 50, nullable = false)
    private String brand;

    @Column(name="type", length = 20, nullable = false)
    private String type;

    @ManyToOne
    private Employee employee;

    public Laptop(String brand, String type) {
        this.brand=brand;
        this.type=type;
    }
}
