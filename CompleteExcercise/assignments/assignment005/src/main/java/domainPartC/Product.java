package domainPartC;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="products")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="productId", updatable = false, nullable = false)
    private Integer id;

    @Column(name="productName", nullable = false)
    private String name;

    @Column(name="productDescription")
    private String description;
}
