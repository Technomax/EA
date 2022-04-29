import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.StringTokenizer;

@Entity
public class Person {

    /*
    //when these are placed for field then table is created by field
    @Id
    @GeneratedValue*/
    private long id;
    private String firstName;
    private String lastName;

    public Person() {
    }

    /*
    //when these are placed for field then table is created by property
    @Id
    @GeneratedValue*/
    @Id
    @GeneratedValue
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        StringTokenizer st = new StringTokenizer(name);
        this.firstName = "Anil";
        this.lastName = "Maharjan";
    }

    public String getFirstname() {
        return this.firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return this.lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

}
