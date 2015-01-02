package mum.pm.ebazaar.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.repository.CategoryDao;
import mum.pm.ebazaar.service.CategoryService;

public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category create(Category category) {
		//categoryDao.save(category);
		return category;
		
	}

	@Override
	public Category read(long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long categoryId, Category card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int categoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
