package mum.pm.ebazaar.repository;

import mum.pm.ebazaar.domain.Customer;

public interface CustomerDao extends GenericDAO<Customer, Long> {

    public Customer getByUsername(String userName);
}
