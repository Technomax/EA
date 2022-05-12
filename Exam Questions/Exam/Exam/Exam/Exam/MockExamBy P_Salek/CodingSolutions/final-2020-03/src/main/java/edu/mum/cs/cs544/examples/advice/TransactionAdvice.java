package edu.mum.cs.cs544.examples.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TransactionAdvice {
	@Autowired
    SessionFactory sessionFactory;
	
	@Around("execution(* edu.mum.cs.cs544.examples.service.*.*(..))")
	public Object profile(ProceedingJoinPoint call) throws Throwable {
		StopWatch clock = new StopWatch("");
		clock.start(call.toShortString());
		
		Object object = null;
		Session session = null;
		Transaction tx = null;
		try {
			tx = sessionFactory.getCurrentSession().beginTransaction();		
			object = call.proceed();		
			tx.commit();
		} 
		catch(HibernateException ex) {
			if(null != tx) tx.rollback();
		}
		finally {
			if(null != session) session.close();
		}

		clock.stop();
		
		System.out.println("This is the clock" + clock.prettyPrint());
		
		return object;
	}
}