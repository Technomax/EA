import domain.Appointment;
import domain.Doctor;
import domain.Patient;
import domain.Payment;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Arrays;

public class App {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = DBConnectionFactory.getSessionFactory(Arrays.asList(Doctor.class, Patient.class, Appointment.class));
    }

    public static void save() {
        DBConnectionFactory.apply(session -> {
            Appointment appointment = new Appointment(null, LocalDate.of(2008, 05, 15), null, null, null);
            Patient patient = new Patient(null, "John Doe", "100 Main Street", "Bostan", "23114");
            Doctor doctor = new Doctor(null, "Eye Doctor", "Frank", "Brown");
            Payment payment = new Payment(LocalDate.of(2008, 06, 12), 100);
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            appointment.setPayment(payment);
            session.persist(appointment);
            session.persist(patient);
            session.persist(doctor);
        });
    }

    public static void print() {
        DBConnectionFactory.apply(session -> {
            System.out.println("--------------Appointment list-----------------------");
            Query customerQuery = session.createQuery("from Appointment ");
            customerQuery.list().forEach(System.out::println);
            System.out.println("--------------Patient list-----------------------");
            Query orderQuery = session.createQuery("from Patient");
            orderQuery.list().forEach(System.out::println);
            System.out.println("--------------Doctor list-----------------------");
            Query productQuery = session.createQuery("from Doctor ");
            productQuery.list().forEach(System.out::println);
        });
    }

    public static void main(String[] args) {
        save();
        print();
    }
}
