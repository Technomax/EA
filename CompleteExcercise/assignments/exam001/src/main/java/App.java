import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Arrays;


//https://thorben-janssen.com/ultimate-guide-association-mappings-jpa-hibernate/#:~:text=Association%20mappings%20are%20one%20of,and%20JPQL%20or%20Criteria%20queries.

public class App {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory=DBConnectionFactory.getSessionFactory(Arrays.asList(Address.class,Course.class,Faculty.class, Grade.class, Person.class, Student.class));
    }

//    public static void save() {
//        DBConnectionFactory.apply(session -> {
//            Owner owner1 = new Owner(null, "Anil", "FairField", new ArrayList<>());
//            Car car1 = new Car(null, "Toyota", "2010", 20000);
//            Car car2 = new Car(null, "BMW", "2015", 40000);
//            owner1.setCars(Arrays.asList(car1, car2));
//            session.persist(car1);
//            session.persist(car2);
//            session.persist(owner1);
//        });
//    }


    public static void student() {
        DBConnectionFactory.apply(session -> {
            Query query=session.createQuery("select distinct  a from Student a join a.grades b join b.course c where  c.name=:name and b.grade>=:grade");
            query.setParameter("name","544");
            query.setParameter("grade","3.4");
        });
    }

    public static void faculty() {
        DBConnectionFactory.apply(session -> {
            Query query=session.createQuery("select distinct  a from Faculty a join a.biography b  where length(b)>:biography");
            query.setParameter("biography","1000");
        });
    }

    public static void main(String[] args){
//        save();
    }
}
