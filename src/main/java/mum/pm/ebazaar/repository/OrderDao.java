package mum.pm.ebazaar.repository;


import mum.pm.ebazaar.domain.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order,Long>{

}
