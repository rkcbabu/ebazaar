package mum.pm.ebazaar.service;

import java.util.List;

import mum.pm.ebazaar.domain.Payment;
import mum.pm.ebazaar.domain.ShoppingCart;

public interface ShoppingCartService {
	
	public List<ShoppingCart> getAll();

	public void create(ShoppingCart shoppingcart);
	
	public void update(ShoppingCart shoppingcart);
	
	public void delete(ShoppingCart shoppingcart);

}
