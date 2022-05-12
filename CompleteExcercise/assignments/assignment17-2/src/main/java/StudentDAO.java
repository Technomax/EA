import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

public class StudentDAO {

	private SessionFactory sf;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public StudentDAO(){}

	@Transactional(propagation= Propagation.REQUIRES_NEW)
	public void save() {
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
//		sf.getCurrentSession().save(student);
//		sf.getCurrentSession().save(course1);
//		sf.getCurrentSession().save(course2);
	}

	public Student load(long studentid) {
		Query query = sf.getCurrentSession().createQuery("select distinct a from Student a where a.studentid=:studentid");
		query.setMaxResults(1);
		query.setParameter("studentid", studentid);
		Student student = (Student) query.list().get(0);
		return student;
	}
}
