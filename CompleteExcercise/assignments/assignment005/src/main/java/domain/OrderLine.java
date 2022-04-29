package domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name="orderLines")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderLineId", updatable = false, nullable = false)
    private Integer id;

    @Column(name="orderQuantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="product_order_id")
    private Product product;
}
