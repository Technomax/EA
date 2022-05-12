package dao;

import domain.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();
	private static Configuration configuration = new Configuration();
	private static SessionFactory sessionFactory;
	static {
		sessionFactory = HibernateUtils.getSessionFactory();
	}

// SOLUTION FOR QUESTION 1
//	public void saveAccount(Account account) {
//		System.out.println("AccountDAO: saving account with accountNr ="+account.getAccountNumber());
//		Session session=null;
//		Transaction txn=null;
//		try {
//			session = sessionFactory.openSession();
//			txn = session.beginTransaction();
//			session.save(account);
//			txn.commit();
//			session.close();
//		} catch(Exception ex){
//			txn.rollback();
//			ex.printStackTrace();
//		}
//		finally{
//			if(session!=null){
//				session.close();
//			}
//		}
//	}

	public void saveAccount(Account account) {
		System.out.println("AccountDAO: saving account with accountNr =" + account.getAccountNumber());
		HibernateUtils.getSessionFactory().getCurrentSession().save(account);
	}

	//For question 1
//	public void updateAccount(Account account) {
//		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
//		Session session=null;
//		Transaction txn=null;
//		try {
//			session = sessionFactory.openSession();
//			txn = session.beginTransaction();
//			session.saveOrUpdate(account);
//			txn.commit();
//			session.close();
//		} catch(Exception ex){
//			txn.rollback();
//			ex.printStackTrace();
//		}
//		finally{
//			if(session!=null){
//				session.close();
//			}
//		}
//	}

	public void updateAccount(Account account) {
		System.out.println("AccountDAO: update account with accountnr =" + account.getAccountNumber());
		HibernateUtils.getSessionFactory().getCurrentSession().saveOrUpdate(account);
	}
// For Question 1
//	public Account loadAccount(long accountnumber) {
//		System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
//		Session session=null;
//		Transaction txn=null;
//		Account account= null;
//		try {
//			session = sessionFactory.openSession();
//			txn = session.beginTransaction();
//			Query query=session.createQuery("select distinct a from Account a left join fetch a.entryList b where a.accountNumber=:accountnumber");
//			query.setMaxResults(1);
//			query.setParameter("accountnumber",accountnumber);
//			account= (Account) query.list().get(0);
//			txn.commit();
//			session.close();
//		} catch(Exception ex){
//			txn.rollback();
//			ex.printStackTrace();
//		}
//		finally{
//			if(session!=null){
//				session.close();
//			}
//		}
//		return account;
//	}

	public Account loadAccount(long accountnumber) {
		System.out.println("AccountDAO: loading account with accountnr =" + accountnumber);
		Query query = HibernateUtils.getSessionFactory().getCurrentSession().createQuery("select distinct a from Account a left join fetch a.entryList b where a.accountNumber=:accountnumber");
		query.setMaxResults(1);
		query.setParameter("accountnumber", accountnumber);
		return (Account) query.list().get(0);
	}
// For Question 1
//	public Collection<Account> getAccounts() {
//		System.out.println("AccountDAO: loading accounts");
//		Session session=null;
//		Transaction txn=null;
//		Collection<Account> accounts=null;
//		try {
//			session = sessionFactory.openSession();
//			txn = session.beginTransaction();
//			Query query=session.createQuery("select distinct a from Account a left join fetch a.entryList b");
//			accounts= query.list();
//			txn.commit();
//			session.close();
//		} catch(Exception ex){
//			txn.rollback();
//			ex.printStackTrace();
//		}
//		finally{
//			if(session!=null){
//				session.close();
//			}
//		}
//		return accounts;
//	}

	public Collection<Account> getAccounts() {
		System.out.println("AccountDAO: loading accounts");
		Collection<Account> accounts = null;
		Query query = HibernateUtils.getSessionFactory().getCurrentSession().createQuery("select distinct a from Account a left join fetch a.entryList b");
		accounts= query.list();
		return accounts;
	}
}
