import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;

public class DBConnectionFactory {
    private static SessionFactory sessionFactory;
    private static Configuration configuration= new Configuration();

    public static SessionFactory getSessionFactory(List<Class> entityClasses) {
        if (sessionFactory == null) {
            try {
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/cs544");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "technomax");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(Environment.SHOW_SQL, "false");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties(settings);
                entityClasses.forEach(entityClass -> configuration.addAnnotatedClass(entityClass));
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void apply(Consumer<Session> consumer){
        Session session=null;
        Transaction txn=null;
        try {
            session = sessionFactory.openSession();
            txn = session.beginTransaction();
            consumer.accept(session);
            txn.commit();
            session.close();
        } catch(Exception ex){
            txn.rollback();
            ex.printStackTrace();
        }
        finally{
            if(session!=null){
                session.close();
            }
        }
    }
}
