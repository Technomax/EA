package domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerId", updatable = false, nullable = false)
    private Integer id;

    @Column(name="firstName", length = 150, nullable = false)
    private String firstName;

    @Column(name="lastName", length = 150)
    private String lastName;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders= new ArrayList<>();

}
