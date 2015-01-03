package mum.pm.ebazaar.repository;


import mum.pm.ebazaar.domain.Admin;
import mum.pm.ebazaar.domain.OrderItem;

import org.springframework.data.repository.CrudRepository;

public interface OrderItemDao extends GenericDAO<OrderItem, Long> {

}
