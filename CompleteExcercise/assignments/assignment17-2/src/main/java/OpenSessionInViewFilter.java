import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;

import java.io.IOException;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
	private SessionFactory sf;

	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
		Transaction tx = null;
		try {
			tx = sf.getCurrentSession().beginTransaction();
			// pass the request along the filter chain
			System.out.println("receiving request");
			chain.doFilter(request, response);
			System.out.println("sending response");
			tx.commit();
		} catch (RuntimeException ex) {
			try {
				ex.printStackTrace();
				tx.rollback();
			} catch (RuntimeException rbEx) {
				System.out.println("Could not rollback transaction " + rbEx);
				rbEx.printStackTrace();
			}
			throw ex;
		}
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
		ApplicationContext context= new ClassPathXmlApplicationContext("springconfig.xml");
		sf=context.getBean("sessionFactory",SessionFactory.class);
	}
}
