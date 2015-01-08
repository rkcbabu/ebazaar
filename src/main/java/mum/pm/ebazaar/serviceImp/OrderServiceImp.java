/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.serviceImp;

import java.util.List;
import mum.pm.ebazaar.domain.Order;
import mum.pm.ebazaar.repository.OrderDao;
import mum.pm.ebazaar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ghenet
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public void create(Order order) {
        orderDao.create(order);
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Override
    public void delete(Order order) {
        orderDao.delete(order);
    }

    @Override
    public Order findByOrderId(String orderId) {
        return orderDao.findByConfirmation(orderId);
    }
    
}
