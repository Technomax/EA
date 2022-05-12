package service;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import domain.Account;
import domain.Customer;
import jms.JMSSender;
import jms.JMSSenderImpl;
import logging.Logger;
import logging.LoggerImpl;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collection;


public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	private CurrencyConverter currencyConverter;
	private JMSSender jmsSender;
	private Logger logger;
	private SessionFactory sf;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public AccountServiceImpl(AccountDAOImpl accountDAO,CurrencyConverterImpl currencyConverter,
							  JMSSenderImpl jmsSender,LoggerImpl logger){
		this.accountDAO=accountDAO;
		this.currencyConverter= currencyConverter;
		this.jmsSender =  jmsSender;
		this.logger = logger;
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber,new ArrayList<>(),null);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		//For question 2
		Transaction tx = sf.getCurrentSession().beginTransaction();
		accountDAO.saveAccount(account);
		//For question 2
		tx.commit();
		logger.log("createAccount with parameters accountNumber= "+accountNumber+" , customerName= "+customerName);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		//For question 2
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		//For question 2
		tx.commit();
		logger.log("deposit with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amount > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
	}

	public Account getAccount(long accountNumber) {
		//For question 2
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		//For question 2
		tx.commit();
		return account;
	}

	public Collection<Account> getAllAccounts() {
		//For question 2
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Collection<Account> result= accountDAO.getAccounts();
		//For question 2
		tx.commit();
		return result;
	}

	public void withdraw(long accountNumber, double amount) {
		//For question 2
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		//For question 2
		tx.commit();
		logger.log("withdraw with parameters accountNumber= "+accountNumber+" , amount= "+amount);
	}

	public void depositEuros(long accountNumber, double amount) {
		//For question 2
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountDAO.updateAccount(account);
		//For question 2
		tx.commit();
		logger.log("depositEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amountDollars > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
	}

	public void withdrawEuros(long accountNumber, double amount) {
		//For question 2
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountDAO.updateAccount(account);
		//For question 2
		tx.commit();
		logger.log("withdrawEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		//For question 2
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		//For question 2
		tx.commit();
		logger.log("transferFunds with parameters fromAccountNumber= "+fromAccountNumber+" , toAccountNumber= "+toAccountNumber+" , amount= "+amount+" , description= "+description);
		if (amount > 10000){
			jmsSender.sendJMSMessage("TransferFunds of $ "+amount+" from account with accountNumber= "+fromAccount+" to account with accountNumber= "+toAccount);
		}
	}
}
