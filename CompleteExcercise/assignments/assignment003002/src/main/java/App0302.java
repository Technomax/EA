import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.*;

public class App0302 {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory = DBConnectionFactory.getSessionFactory(Arrays.asList(
               Employee.class, Department.class
//                Publisher.class, Book.class,
//                Student.class, Course.class,
//                Customer.class, Reservation.class,
//                CustomerAlt.class, ReservationAlt.class, BookAlt.class,
//                EmployeeAlt.class, DepartmentAlt.class, Office.class
        ));
    }

    //Create a Bidirectional OneToMany association between Department and Employee
    //using annotations.
    public static void case01() {
        DBConnectionFactory.apply(session -> {
            Department department = new Department("Compro");
            Employee employee1 = new Employee(null, "Anil", department);
            Employee employee2 = new Employee(null, "Ashish", department);
            List<Employee> employees = new ArrayList<>();
            employees.add(employee1);
            employees.add(employee2);
            department.setEmployees(employees);
            session.persist(department);
            session.persist(employee1);
            session.persist(employee2);
        });
    }

    //Create an Optional Unidirectional ManyToOne association between Book and
    //Publisher using annotations and without using NULL fields in the database
    public static void case02() {
        DBConnectionFactory.apply(session -> {
            Publisher publisher = new Publisher("WROX");
            Book book1 = new Book(null, "React", "Mady",publisher);
            Book book2 = new Book(null, "Angular", "Flower",publisher);
            List<Book> books = new ArrayList<>();
            books.add(book1);
            books.add(book2);
            publisher.setBooks(books);
            session.persist(publisher);
            session.persist(book1);
            session.persist(book2);
        });
    }

    //Create a Bidirectional ManyToMany association between Student and Course using
    //annotations.
    public static void case03() {
        DBConnectionFactory.apply(session -> {
            Student student1 = new Student("Anil","Maharjan");
            Student student2 = new Student("Ashish","Ghimire");
            Course course1 = new Course("AP001", "React");
            Course course2 = new Course("AP002", "Angular");
            List<Student> students = new ArrayList<>();
            students.add(student1);
            students.add(student2);

            List<Course> courses = new ArrayList<>();
            courses.add(course1);
            courses.add(course2);

            student1.setCourses(courses);
            student2.setCourses(courses);
            course1.setStudents(students);
            course2.setStudents(students);

            session.persist(course1);
            session.persist(course2);

            session.persist(student1);
            session.persist(student2);
        });
    }

    //Create a Unidirectional OneToMany association between Customer and Reservation
    //using annotations.
    public static void case04() {
        DBConnectionFactory.apply(session -> {
            Customer customer = new Customer("Anil Maharjan");
            Reservation reservation1 = new Reservation(null, LocalDate.of(2021,01,01));
            Reservation reservation2 = new Reservation(null, LocalDate.of(2021,02,02));
            List<Reservation> reservations = new ArrayList<>();
            reservations.add(reservation1);
            reservations.add(reservation2);
            customer.setReservations(reservations);
            session.persist(customer);
            session.persist(reservation1);
            session.persist(reservation2);
        });
    }

    //Create a Unidirectional ManyToOne association between Reservation and Book using
    //annotations.
    public static void case05() {
        DBConnectionFactory.apply(session -> {
            CustomerAlt customerAlt = new CustomerAlt("Anil Maharjan");
            BookAlt bookAlt=new BookAlt("Hedge", "Mady Hedge");
            ReservationAlt reservation1 = new ReservationAlt(null, LocalDate.of(2021,01,01));
            ReservationAlt reservation2 = new ReservationAlt(null, LocalDate.of(2021,02,02));


            List<ReservationAlt> reservations = new ArrayList<>();
            reservations.add(reservation1);
            reservations.add(reservation2);

            customerAlt.setReservations(reservations);
            bookAlt.setReservations(reservations);

            session.persist(customerAlt);
            session.persist(bookAlt);
            session.persist(reservation1);
            session.persist(reservation2);
        });
    }

    //Create a Bidirectional ManyToOne association between Employee and Office using
    //annotations.
    public static void case06() {
        DBConnectionFactory.apply(session -> {
            DepartmentAlt department = new DepartmentAlt("Compro");
            Office office = new Office("Highlander");
            EmployeeAlt employee1 = new EmployeeAlt(null, "Anil", department,office);
            EmployeeAlt employee2 = new EmployeeAlt(null, "Ashish", department, office);
            List<EmployeeAlt> employees = new ArrayList<>();
            employees.add(employee1);
            employees.add(employee2);
            department.setEmployees(employees);
            office.setEmployees(employees);
            session.persist(department);
            session.persist(office);
            session.persist(employee1);
            session.persist(employee2);
        });
    }


    public static void main(String[] args) {
        case01();
//        case02();
//        case03();
//        case04();
//        case05();
//        case06();
    }
}
