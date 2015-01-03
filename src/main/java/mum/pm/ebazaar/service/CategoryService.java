package mum.pm.ebazaar.service;

import java.util.List;



import mum.pm.ebazaar.domain.Admin;
import mum.pm.ebazaar.domain.Category;

public interface CategoryService {
	
	public Category get(long id);

	public List<Category> getAll();

	public void create(Category category);
	
	public void update(Category category);
	
	public void delete(Category category);

}
