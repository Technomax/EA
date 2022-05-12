import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class App {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory = DBConnectionFactory.getSessionFactory(Arrays.asList(Owner.class, Pet.class));
    }

    public static void fillDataBase() {
        DBConnectionFactory.apply(session -> {
            for (int x = 0; x < 1000; x++) {
                Owner owner = new Owner("Frank" + x);
                List<Pet> petlist = new ArrayList<Pet>();
                for (int y = 0; y < 10; y++) {
                    Pet pet = new Pet("Garfield" + x + "-" + y);
                    petlist.add(pet);
                }
                owner.setPets(petlist);
                session.persist(owner);
            }
        });
    }

    public static void executeQuery() {
        DBConnectionFactory.apply(session -> {
            //SOLUTION 1: Run the application as is, without any optimization, and note the time. Run the
//                    @SuppressWarnings("deprecation")
//                    Criteria criteria = session.createCriteria(Owner.class);
//                    @SuppressWarnings("unchecked")
//                    List<Owner> ownerlist = criteria.list();
//                    for (Owner owner : ownerlist) {
//                        for (Pet pet : owner.getPets()) {
//                            System.out.println("Owner name= " + owner.getName()
//                                    + "pet name= " + pet.getName());
//                        }
//                    }
//                });

            //SOLUTION 3: Remove the sub-select strategy and use a join fetch query in Application.java to retrieve
//            Query query = session.createQuery("select distinct a from Owner a  left join fetch  a.pets b");
//            List<Owner> ownerlist = query.list();
//            for (Owner owner : ownerlist) {
//                for (Pet pet : owner.getPets()) {
//                    System.out.println("Owner name= " + owner.getName()
//                            + "pet name= " + pet.getName());
//                }
//            }

            //SOLUTION 4: Lastly modify the application to use the always join strategy
            Query query = session.createQuery("select distinct a from Owner a  join  a.pets b");
            List<Owner> ownerlist = query.list();
            for (Owner owner : ownerlist) {
                for (Pet pet : owner.getPets()) {
                    System.out.println("Owner name= " + owner.getName()
                            + "pet name= " + pet.getName());
                }
            }
        });
    }


    public static void main(String[] args) {
//        fillDataBase();
        // start time
        long start = System.nanoTime();
        executeQuery();
        // stop time
        long stop = System.nanoTime();
        System.out.println("To fetch this data from the database took "
                + (stop - start) / 1000000 + " milliseconds.");
        System.exit(0);
    }
}
