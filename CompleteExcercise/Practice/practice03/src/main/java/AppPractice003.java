import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//https://thorben-janssen.com/ultimate-guide-association-mappings-jpa-hibernate/#:~:text=Association%20mappings%20are%20one%20of,and%20JPQL%20or%20Criteria%20queries.

public class AppPractice003 {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory=DBConnectionFactory.getSessionFactory(Arrays.asList(Customer.class,Car.class));
    }

    public static void save() {
        DBConnectionFactory.apply(session -> {
            Customer customer1=new Customer();
            customer1.setFirstName("Anil");
            customer1.setLastName("Maharjan");

            Customer customer2=new Customer();
            customer2.setFirstName("nisha");
            customer2.setLastName("Maharjan");
            List<Car> cars= new ArrayList<>();
            Car car1=new Car();
            car1.setYear(2000);
            car1.setMaker("to");
            car1.setModel("2000");
            Car car2=new Car();
            car2.setYear(5000);
            car2.setMaker("to");
            car2.setModel("2000");
            cars.add(car1);
            cars.add(car2);

            List<Customer> customers= new ArrayList<>();
            customers.add(customer1);
            customers.add(customer2);

            customer1.setCars(cars);
            car1.setCustomers(customers);
            car2.setCustomers(customers);

            session.persist(customer1);
            session.persist(customer2);
            session.persist(car1);
            session.persist(car2);
        });
    }


    public static void main(String[] args){
        save();
    }
}
