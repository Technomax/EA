package domainPartC;

import domainPartC.Customer;
import domainPartC.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderId", updatable = false, nullable = false)
    private Integer id;

    @Column(name="orderDate", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="customer_order_id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name="order_id")
    private List<OrderLine> orderLines= new ArrayList<>();

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", orderLines=" + orderLines +
                '}';
    }
}
