package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.domain.ShoppingCart;
import mum.pm.ebazaar.repository.CategoryDao;
import mum.pm.ebazaar.repository.ShoppingCartDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImp extends GenericHibernateDaoImpl<ShoppingCart, Long> implements ShoppingCartDao {

//    @Override
//    public ShoppingCart findByUser(Customer customer) {
//        Query query = sessionFactory.getCurrentSession().createQuery("FROM ShoppingCart u WHERE u.customer = :customer");
//    query.setParameter("customer", customer);
//        @SuppressWarnings("unchecked")
//        Customer cus = query.list();
//        return users;
//    }
   @Override
    public ShoppingCart findByUser(Customer customer) {
        return (ShoppingCart) sessionFactory.getCurrentSession().createQuery("SELECT u FROM ShoppingCart u WHERE u.customer = ?").setParameter(0, customer).uniqueResult();

    }
}
