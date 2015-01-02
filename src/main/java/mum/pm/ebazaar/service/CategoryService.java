package mum.pm.ebazaar.service;

import java.util.List;


import mum.pm.ebazaar.domain.Category;

public interface CategoryService {
	
	Category create(Category category);

	Category read(long categoryId);

	void update(long categoryId, Category card);

	void delete(int categoryId);

	public List<Category> findAll();

}
