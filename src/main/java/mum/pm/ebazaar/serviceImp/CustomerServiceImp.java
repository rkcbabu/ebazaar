package mum.pm.ebazaar.serviceImp;

import java.util.List;

import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.repository.CustomerDao;
import mum.pm.ebazaar.repository.UserDao;
import mum.pm.ebazaar.repositoryImp.UserDaoImp;
import mum.pm.ebazaar.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)

public class CustomerServiceImp implements CustomerService {
	
	@Autowired
    private CustomerDao customerDao;

	@Override
	public Customer get(long id) {
		Customer customer = customerDao.get(id);
		return customer;
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> listCustomer = customerDao.getAll();
		return listCustomer;
	}

	@Override
	public void create(Customer customer) {
		customerDao.create(customer);
		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
	}
   

    @Override
     public Customer getUserByUsername(String username) {
        return customerDao.findByUsername(username);
    }
}
