package mum.pm.ebazaar.repository;


import mum.pm.ebazaar.domain.Admin;
import mum.pm.ebazaar.domain.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends GenericDAO<Customer, Long> {

}
