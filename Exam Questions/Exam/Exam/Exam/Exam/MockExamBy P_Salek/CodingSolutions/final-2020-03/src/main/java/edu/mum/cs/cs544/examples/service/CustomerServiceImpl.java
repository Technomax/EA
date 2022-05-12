package edu.mum.cs.cs544.examples.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs544.examples.dao.CustomerDAO;
import edu.mum.cs.cs544.examples.entity.Country;
import edu.mum.cs.cs544.examples.entity.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	public List<Customer> getCustomerList(Country country) {
		return customerDAO.getCustomerList(country);
	}
	
	public void saveCountry(Country country) {
		throw new HibernateException("Fake error");		
	}
	
	
}
