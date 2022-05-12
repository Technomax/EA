import domain.Course;
import domain.Student;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Arrays;


public class App {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory=DBConnectionFactory.getSessionFactory(Arrays.asList(Student.class, Course.class));
    }
    public static void main(String[] args){
    }
}
