import domainPartC.*;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class AppPartC {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory=DBConnectionFactory.getSessionFactory(Arrays.asList(Customer.class, Order.class,
                       OrderLine.class, CD.class, DVD.class, Book.class));
    }

    public static void save() {
        DBConnectionFactory.apply(session -> {
            Customer customer=new Customer(null,"Anil","Maharjan",new ArrayList<>());
            Order orderA= new Order(null, LocalDate.of(2022,1,2),customer,new ArrayList<>());
            customer.setOrders(Arrays.asList(orderA));

            Product CD= new CD("BOB Marly", "Clssical Movie","Clssical Movie");
            Product DVD= new DVD("Titanic", "Western Movie","Western Movie");
            Product book= new Book("Last Resort", "Destination","Destination");

            OrderLine orderLineA=new OrderLine(null,10,CD);
            OrderLine orderLineB=new OrderLine(null,20,DVD);
            OrderLine orderLineC=new OrderLine(null,20,book);

            orderA.setOrderLines(Arrays.asList(orderLineA,orderLineB,orderLineC));

            session.persist(customer);
            session.persist(orderA);
            session.persist(CD);
            session.persist(DVD);
            session.persist(book);
            session.persist(orderLineA);
            session.persist(orderLineB);
            session.persist(orderLineC);
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

    public static void main(String[] args) {
        save();
        print();
    }
}
