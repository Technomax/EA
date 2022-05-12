package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AccountEntry {
	private Date date;
	private double amount;
	private String description;
	private String fromAccountNumber;
	private String fromPersonName;
	
}
