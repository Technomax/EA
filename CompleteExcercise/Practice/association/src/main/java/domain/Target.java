package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Target {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String targetValue;

    @OneToOne(mappedBy = "target")
    private Source source;
}
