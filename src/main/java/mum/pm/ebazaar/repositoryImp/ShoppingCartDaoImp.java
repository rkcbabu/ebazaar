package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.domain.ShoppingCart;
import mum.pm.ebazaar.repository.CategoryDao;
import mum.pm.ebazaar.repository.ShoppingCartDao;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImp extends GenericHibernateDaoImpl<ShoppingCart, Long> implements ShoppingCartDao {

}
