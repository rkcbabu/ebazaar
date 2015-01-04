package mum.pm.ebazaar.repositoryImp;
import org.springframework.stereotype.Repository;
import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.repository.CategoryDao;

@Repository
public class CategoryDaoImp extends GenericHibernateDaoImpl<Category, Long> implements CategoryDao {

}
