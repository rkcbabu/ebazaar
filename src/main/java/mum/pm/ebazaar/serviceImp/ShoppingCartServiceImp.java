package mum.pm.ebazaar.serviceImp;

import java.util.List;

import mum.pm.ebazaar.domain.ShoppingCart;
import mum.pm.ebazaar.repository.PaymentDao;
import mum.pm.ebazaar.repository.ShoppingCartDao;
import mum.pm.ebazaar.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)

public class ShoppingCartServiceImp implements ShoppingCartService {
	
	
	@Autowired
    private ShoppingCartDao shoppingcartDao;

	@Override
	public List<ShoppingCart> getAll() {
		List<ShoppingCart> listShoppingCart = shoppingcartDao.getAll();
		
		return listShoppingCart;
	}

	@Override
	public void create(ShoppingCart shoppingcart) {
		shoppingcartDao.create(shoppingcart);
		
	}

	@Override
	public void update(ShoppingCart shoppingcart) {
		shoppingcartDao.update(shoppingcart);
		
	}

	@Override
	public void delete(ShoppingCart shoppingcart) {
		shoppingcartDao.delete(shoppingcart);
		
	}

}
