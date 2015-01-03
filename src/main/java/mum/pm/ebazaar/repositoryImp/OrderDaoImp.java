package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.domain.Order;
import mum.pm.ebazaar.repository.CategoryDao;
import mum.pm.ebazaar.repository.OrderDao;
import org.springframework.stereotype.Repository;
@Repository
public class OrderDaoImp extends GenericHibernateDaoImpl<Order, Long> implements OrderDao {

}
