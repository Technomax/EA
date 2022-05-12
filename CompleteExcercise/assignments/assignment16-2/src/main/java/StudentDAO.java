import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;

public class StudentDAO {

	private Collection<Student> studentlist = new ArrayList<Student>();
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtils.getSessionFactory();
	}

	public StudentDAO() {
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		HibernateUtils.getSessionFactory().getCurrentSession().save(student);
		HibernateUtils.getSessionFactory().getCurrentSession().save(course1);
		HibernateUtils.getSessionFactory().getCurrentSession().save(course2);
	}

	public Student load(long studentid) {
		Query query = HibernateUtils.getSessionFactory().getCurrentSession().createQuery("select distinct a from Student a where a.studentid=:studentid");
		query.setMaxResults(1);
		query.setParameter("studentid", studentid);
		Student student = (Student) query.list().get(0);
		return student;
	}
}
