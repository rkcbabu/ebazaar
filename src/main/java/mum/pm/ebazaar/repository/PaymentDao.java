package mum.pm.ebazaar.repository;


import mum.pm.ebazaar.domain.Admin;
import mum.pm.ebazaar.domain.Payment;

import org.springframework.data.repository.CrudRepository;

public interface PaymentDao extends GenericDAO<Payment, Long>{

}
