import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.Arrays;


//https://thorben-janssen.com/ultimate-guide-association-mappings-jpa-hibernate/#:~:text=Association%20mappings%20are%20one%20of,and%20JPQL%20or%20Criteria%20queries.

public class App {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory=DBConnectionFactory.getSessionFactory(Arrays.asList(Owner.class,Car.class));
    }

    public static void save() {
        DBConnectionFactory.apply(session -> {
            Owner owner1=new Owner(null,"Anil","FairField");
            Owner owner2=new Owner(null,"Nisha","Burlinton");
            Car car1=new Car(null,"Toyota","2010",5000.00,owner1);
            Car car2=new Car(null,"BMW","2015",50000.00,owner1);
            Car car3=new Car(null,"Toyota","2010",6000.00,owner1);
            Car car4=new Car(null,"BMW","2015",70000.00,owner2);
            session.persist(owner1);
            session.persist(owner2);
            session.persist(car1);
            session.persist(car2);
            session.persist(car3);
            session.persist(car4);
        });
    }

    public static void print() {
        DBConnectionFactory.apply(session -> {
            Query query = session.createQuery("from Car");
            query.list().forEach(System.out::println);
        });
    }

    public static void main(String[] args){
        save();
        print();
    }
}
