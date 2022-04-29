import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.*;

//https://www.coderscampus.com/hibernate-onetomany-bidirectional-relationship/
//https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

public class App {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory=DBConnectionFactory.getSessionFactory(Arrays.asList(Employee.class,Flight.class,
                       Laptop.class, Passenger.class,School.class, Student.class ));
    }

    //bidirectional OneToMany/ManyToOne between Employee and Laptop using Set
    public static void case01() {
        DBConnectionFactory.apply(session -> {
            Employee employee= new Employee("Anil","Maharjan");
             Laptop laptop1= new Laptop("Dell","XPS");
             laptop1.setEmployee(employee);
             Laptop laptop2= new Laptop("Razor","Blade");
             laptop2.setEmployee(employee);

             Set laptops= new HashSet();
             laptops.add(laptop1);
             laptops.add(laptop2);
             employee.setLaptops(laptops);

             session.persist(laptop1);
            session.persist(laptop2);
            session.persist(employee);
        });
    }

    //Unidirectional OneToMany between Passenger and Flight using a List
    public static void case02() {
        DBConnectionFactory.apply(session -> {
            Flight flight1= new Flight(null,"DX101","KTM", "DOH", LocalDate.of(2020,01,02));
            Flight flight2= new Flight(null,"DX102","DOH", "ORD", LocalDate.of(2020,01,03));
            Passenger passenger= new Passenger("Anil Maharjan");
            List<Flight> lst=new ArrayList<>();
            lst.add(flight1);
            lst.add(flight2);
            passenger.setFlights(lst);

            session.persist(passenger);
            session.persist(flight1);
            session.persist(flight2);
        });
    }

    //Unidirectional OneToMany between School and Student using Map where studentId is used as the key for the map
    public static void case03() {
        DBConnectionFactory.apply(session -> {
            School school=new School("MIU");
            Student student1=new Student(null,"Anil","Maharjan");
            Student student2=new Student(null,"Ashish","Ghimire");

            Map<Long,Student> students=new HashMap<>();
            students.put(Long.parseLong("1"),student1);
            students.put(Long.parseLong("2"),student2);
            school.setStudents(students);

            session.persist(school);
            session.persist(student1);
            session.persist(student2);
        });
    }

    public static void main(String[] args){
//        case01();
//        case02();
        case03();
    }
}
