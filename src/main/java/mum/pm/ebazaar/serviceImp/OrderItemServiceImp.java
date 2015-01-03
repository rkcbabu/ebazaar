package mum.pm.ebazaar.serviceImp;

import java.util.List;

import mum.pm.ebazaar.domain.OrderItem;
import mum.pm.ebazaar.repository.CustomerDao;
import mum.pm.ebazaar.repository.OrderItemDao;
import mum.pm.ebazaar.service.OrderItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class OrderItemServiceImp implements OrderItemService{
	
	
	@Autowired
    private OrderItemDao orderItemDao;

	@Override
	public List<OrderItem> getAll() {
		List<OrderItem> listOrderItem = orderItemDao.getAll();
		return listOrderItem;
	}

	@Override
	public void create(OrderItem orderItem) {
		
		orderItemDao.create(orderItem);
	}

	@Override
	public void update(OrderItem orderItem) {
		orderItemDao.update(orderItem);
		
	}

	@Override
	public void delete(OrderItem orderItem) {
		orderItemDao.delete(orderItem);
		
	}

}
