package mum.pm.ebazaar.repository;


import mum.pm.ebazaar.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemDao extends CrudRepository<OrderItem,Long> {

}
