import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;

public class AppPerson {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory=DBConnectionFactory.getSessionFactory(Arrays.asList(Person.class));
    }

    public static void saveSession() {
        Session session = null;
        Transaction tx = null;
        try {
            //step 1: Open a session
            session = sessionFactory.openSession();
            //step 2: open the transaction
            tx = session.beginTransaction();
            //step 3: create pool of Book data
            Person person1 = new Person();
            person1.setId(1);
            person1.setName("Anil Man Maharjan");
//            Book book1=  new Book(null, "Clean Architectusres",
//                    "978-01344941176", "Robert C Martin", 30, new Date());
            //Step 4: persist the data
            person1.setName("New");
            session.save(person1);
            //step 5: commit the transaction
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args){
        //Step 1: save records
        saveSession();
    }
}
