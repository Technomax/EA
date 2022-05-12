import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;


//https://thorben-janssen.com/ultimate-guide-association-mappings-jpa-hibernate/#:~:text=Association%20mappings%20are%20one%20of,and%20JPQL%20or%20Criteria%20queries.

public class App {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory=DBConnectionFactory.getSessionFactory(Arrays.asList(Owner.class,Car.class));
    }

    public static void save() {
        DBConnectionFactory.apply(session -> {
            Owner owner1 = new Owner(null, "Anil", "FairField", new ArrayList<>());
            Car car1 = new Car(null, "Toyota", "2010", 20000);
            Car car2 = new Car(null, "BMW", "2015", 40000);
            owner1.setCars(Arrays.asList(car1, car2));
            session.persist(car1);
            session.persist(car2);
            session.persist(owner1);
        });
    }

    public static void print() {
        System.out.println("==============================");
        DBConnectionFactory.apply(session -> {
            Query query = session.createQuery("from Car a where length(a.brand)<5");
            query.list().forEach(System.out::println);
        });
    }

    public static void main(String[] args){
        save();
        print();
    }
}
