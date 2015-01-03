package mum.pm.ebazaar.repository;


import mum.pm.ebazaar.domain.Admin;
import mum.pm.ebazaar.domain.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends GenericDAO<Order, Long>{

}
