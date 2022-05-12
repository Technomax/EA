package dao;

import domain.Account;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.Collection;

public class AccountDAOImpl implements AccountDAO {
	private SessionFactory sf;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public void saveAccount(Account account) {
		System.out.println("AccountDAO: saving account with accountNr =" + account.getAccountNumber());
		sf.getCurrentSession().save(account);
	}

	public void updateAccount(Account account) {
		System.out.println("AccountDAO: update account with accountnr =" + account.getAccountNumber());
		sf.getCurrentSession().saveOrUpdate(account);
	}

	public Account loadAccount(long accountnumber) {
		System.out.println("AccountDAO: loading account with accountnr =" + accountnumber);
		Query query = sf.getCurrentSession().createQuery("select distinct a from Account a left join fetch a.entryList b where a.accountNumber=:accountnumber");
		query.setMaxResults(1);
		query.setParameter("accountnumber", accountnumber);
		return (Account) query.list().get(0);
	}

	public Collection<Account> getAccounts() {
		System.out.println("AccountDAO: loading accounts");
		Collection<Account> accounts = null;
		Query query = sf.getCurrentSession().createQuery("select distinct a from Account a left join fetch a.entryList b");
		accounts= query.list();
		return accounts;
	}
}
