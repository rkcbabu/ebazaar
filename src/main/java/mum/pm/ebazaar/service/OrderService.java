package mum.pm.ebazaar.service;

import java.util.List;

import mum.pm.ebazaar.domain.Order;

public interface OrderService {
	
	public List<Order> getAll();

	public void create(Order order);
	
	public void update(Order order);
	
	public void delete(Order order);
        
	public Order findByOrderId(String orderId);

}
