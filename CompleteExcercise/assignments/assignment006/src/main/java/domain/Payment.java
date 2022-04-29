package domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Payment {
    @Column(name="PAYDATE")
    private LocalDate payDate;

    @Column(name="AMOUNT")
    private double amount;
}
