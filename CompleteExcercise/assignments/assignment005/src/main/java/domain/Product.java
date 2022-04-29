package domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productId", updatable = false, nullable = false)
    private Integer id;

    @Column(name="productName", nullable = false)
    private String name;

    @Column(name="productDescription")
    private String description;
}
