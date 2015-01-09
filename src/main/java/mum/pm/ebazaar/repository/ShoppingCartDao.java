package mum.pm.ebazaar.repository;


import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.domain.ShoppingCart;


public interface ShoppingCartDao extends GenericDAO<ShoppingCart, Long>{

    public ShoppingCart findByUser(Customer customer);
}
