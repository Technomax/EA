import domain.Source;
import domain.Target;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Arrays;

public class AppAssociation {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = DBConnectionFactory.getSessionFactory(Arrays.asList(Source.class, Target.class));
    }

    public static void save() {
        DBConnectionFactory.apply(session -> {
            Target targetA = new Target(null, "TargetA",null);
            Target targetB = new Target(null, "TargetB",null);
            Source source = new Source(null, "Source Name", targetA);
            targetA.setSource(source);
            session.persist(source);
            session.persist(targetA);
            session.persist(targetB);
        });
    }

    public static void print() {
        DBConnectionFactory.apply(session -> {
            System.out.println("--------------Source list-----------------------");
            Query sourceQuery = session.createQuery("from Source as s join Target as t where s.id=1");
            sourceQuery.list().forEach(System.out::println);
        });
    }

    public static void main(String[] args) {
        save();
        //print();
    }
}
