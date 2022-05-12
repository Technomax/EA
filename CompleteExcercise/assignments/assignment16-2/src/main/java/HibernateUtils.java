import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    
    private static Configuration configuration = new Configuration();
    
    static {
        try {
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/cs544");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "technomax");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            settings.put(Environment.SHOW_SQL, "false");
            settings.put(Environment.HBM2DDL_AUTO, "update");
            //For question 2
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
            configuration.setProperties(settings);
            List<Class> entityClasses = new ArrayList<>();
            entityClasses.add(Student.class);
            entityClasses.add(Course.class);
            entityClasses.forEach(entityClass -> configuration.addAnnotatedClass(entityClass));
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
