package mum.pm.ebazaar.service;

import java.util.List;

import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.domain.OrderItem;

public interface OrderItemService {
	

	public List<OrderItem> getAll();

	public void create(OrderItem orderItem);
	
	public void update(OrderItem orderItem);
	
	public void delete(OrderItem orderItem);

}
