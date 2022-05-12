import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue
    @Column(name="Address_ID")
    private Long id = null;
    private String city;
    private String street;
    private String zip;
}
