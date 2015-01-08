package mum.pm.ebazaar.serviceImp;

import java.util.List;
import mum.pm.ebazaar.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.repository.ProductDao;
import mum.pm.ebazaar.service.ProductService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> getAll() {
		List<Product> listProduct = productDao.getAll();
		return listProduct;
	}

	@Override
	public void create(Product product) {
		productDao.create(product);
		
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
		
	}

	@Override
	public void delete(Product product) {
		productDao.delete(product);
		
	}

	@Override
	public Product findById(long id) {
		Product p = productDao.get(id);
		return p;
	}

    @Override
    public List<Product> productsByKey(String key) {
        return productDao.productsByKey(key);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
