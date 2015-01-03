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
	public Category get(long id) {
	//	Category category = categoryDao.get(id);
		return null;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub
		
	}




}
