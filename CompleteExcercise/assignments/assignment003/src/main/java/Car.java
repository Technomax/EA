import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String brand;

    @Column(nullable = false, precision = 4, scale = 0)
    private String year;

    @Column(precision = 6, scale = 2)
    private double price;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
