package mum.pm.ebazaar.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.repository.CategoryDao;
import mum.pm.ebazaar.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category get(long id) {
//		Category category = categoryDao.get(id);
        return categoryDao.get(id);
//		return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();
        for (Category c : categoryDao.getAll()) {
            if (!categories.contains(c)) {
                categories.add(c);
            }
        }
        // TODO Auto-generated method stub
        return categories;
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
