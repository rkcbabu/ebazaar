package mum.pm.ebazaar.service;

import java.util.List;
import mum.pm.ebazaar.domain.Product;

public interface ProductService {
	
	
	
	public List<Product> getAll();

	public void create(Product product);
	
	public void update(Product product);
	
	public void delete(Product product);

	public Product findById(long id);


}
