package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Order;
import mum.pm.ebazaar.repository.OrderDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImp extends GenericHibernateDaoImpl<Order, Long> implements OrderDao {

    @Override
    public Order findByConfirmation(String orderId) {
       return (Order) sessionFactory.getCurrentSession().createQuery("SELECT o FROM Order o WHERE o.orderID = ?").setParameter(0, orderId).uniqueResult();
        
    }
    
}
