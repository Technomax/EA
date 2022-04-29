import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class AppBook {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory=DBConnectionFactory.getSessionFactory(Arrays.asList(Book.class));
    }

    public static void saveSession(){
        Session session=null;
        Transaction tx=null;
        try {
            //step 1: Open a session
            session = sessionFactory.openSession();
            //step 2: open the transaction
            tx = session.beginTransaction();
            //step 3: create pool of Book data
            Book[] books = {
                    new Book(null, "Enterprise Architecture As Strategy: Creating a Foundation for Business Execution",
                            "978-1591398394", "Jeanne W Ross", 20, new Date()),
                    new Book(null, "Patterns of Enterprise Application Architecture",
                            "978-0321127426", "Martin Flower", 50, new Date()),
                    new Book(null, "Clean Architecture",
                            "978-0134494166", "Robert C Martin", 30, new Date()),
            };
            //Step 4: persist the data
            for(Book book : books) {
                session.persist(book);
            }
            //step 5: commit the transaction
            tx.commit();
        }
        catch(Exception ex){
            tx.rollback();
            ex.printStackTrace();
        }
        finally{
            if(session!=null){
                session.close();
            }
        }
    }

    public static void retriveSession(){
        Session session=null;
        Transaction tx=null;
        try {
            //step 1: Open a session
            session = sessionFactory.openSession();
            //step 2: open the transaction
            tx = session.beginTransaction();
            //step 3: Create query to extract all data
            Query query=session.createQuery("from Book");
            Collection<Book> bookList=query.list();
            bookList.forEach(System.out::println);
            //step 5: commit the transaction
            tx.commit();
        }
        catch(Exception ex){
            tx.rollback();
            ex.printStackTrace();
        }
        finally{
            if(session!=null){
                session.close();
            }
        }
    }

    public static void updateAndDeleteSession(Integer updateId, Integer deleteId){
        Session session=null;
        Transaction tx=null;
        try{
            //step 1 open the connection
            session=sessionFactory.openSession();
            //step 2: open the transaction
            tx=session.beginTransaction();
            //step 3: load the data again updateId using lazy mode
            Book bookForUpdate=(Book)session.load(Book.class, new Integer(updateId));
            //step 4: make necessary changes in the title and price
            bookForUpdate.setTitle("[Updated] "+bookForUpdate.getTitle());
            bookForUpdate.setPrice(bookForUpdate.getPrice()*2);
            //step 5: update the object
            session.update(bookForUpdate);
            //step 6: get record for remove
            Book bookForDelete=(Book)session.load(Book.class,new Integer(deleteId));
            //step 7: remove
            session.delete(bookForDelete);
            //step 8: Commit the transaction
            tx.commit();
        }
        catch(Exception ex){
            tx.rollback();
            ex.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
    }

    public static void updateSession(Integer updateId)
    {
        Session session=null;
        Transaction txn=null;
        try{
            //step 1: open the session
            session=sessionFactory.openSession();
            //step 2: open the transa tion
            txn=session.beginTransaction();
            //step 3: get the record to be updated
            Book book=(Book)session.get(Book.class,updateId);
            //step 4: update the values
            book.setTitle("New Updates:"+book.getTitle());
            //step 5: save the record
            session.update(book);
            //step 6: commit the transaction
            txn.commit();
        }
        catch (Exception ex){
            txn.rollback();
            ex.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void deleteSession(Integer deleteId){
        Session session=null;
        Transaction txn=null;
        try{
            //step 1: open the session
            session=sessionFactory.openSession();
            //step 2: open the transaction
            txn=session.beginTransaction();
            //step 3: retrieve the record
            Book book=(Book)session.get(Book.class,deleteId);
            //step 4: delete the record
            session.delete(book);
            //step 5: commit the transaction
            txn.commit();
        }
        catch (Exception ex){
            txn.rollback();
            ex.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args){
        //Step 1: save records
        saveSession();
        //Step 2: retrive records
        retriveSession();
        //Step 3: update and delete
        updateAndDeleteSession(1,2);
        //Step 4: retrive records
        retriveSession();
    }
}
