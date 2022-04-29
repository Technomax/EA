import domain.Customer;
import domain.Order;
import domain.OrderLine;
import domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.*;
public class App {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory=DBConnectionFactory.getSessionFactory(Arrays.asList(Customer.class, Order.class,
                       OrderLine.class, Product.class ));
    }

    public static void save() {
        DBConnectionFactory.apply(session -> {
            Customer customer=new Customer(null,"Anil","Maharjan",new ArrayList<>());
            Order orderA= new Order(null, LocalDate.of(2022,1,2),customer,new ArrayList<>());
            customer.setOrders(Arrays.asList(orderA));

            Product productA= new Product(null,"Laptop","gaming laptop");
            Product productB= new Product(null,"Printer","inkjet printer");

            OrderLine orderLineA=new OrderLine(null,10,productA);
            OrderLine orderLineB=new OrderLine(null,20,productB);

            orderA.setOrderLines(Arrays.asList(orderLineA,orderLineB));

            session.persist(customer);
            session.persist(orderA);
            session.persist(productA);
            session.persist(productB);
            session.persist(orderLineA);
            session.persist(orderLineB);
        });
    }

    public static void print() {
        DBConnectionFactory.apply(session -> {
            System.out.println("--------------Customer list-----------------------");
            Query customerQuery = session.createQuery("from Customer");
            customerQuery.list().forEach(System.out::println);
            System.out.println("--------------Order list-----------------------");
            Query orderQuery = session.createQuery("from Order");
            orderQuery.list().forEach(System.out::println);
            System.out.println("--------------OrderLine list-----------------------");
            Query orderLineQuery = session.createQuery("from OrderLine");
            orderLineQuery.list().forEach(System.out::println);
            System.out.println("--------------Product list-----------------------");
            Query productQuery = session.createQuery("from Product ");
            productQuery.list().forEach(System.out::println);

        });
    }

    public static void main(String[] args){
        save();
        print();
    }
}
