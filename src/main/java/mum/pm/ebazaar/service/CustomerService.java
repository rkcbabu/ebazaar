package mum.pm.ebazaar.service;

import java.util.List;

import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.domain.Customer;

public interface CustomerService {
	public Customer get(long id);

	public List<Customer> getAll();

	public void create(Customer customer);
	
	public void update(Customer customer);
	
	public void delete(Customer customer);

}
