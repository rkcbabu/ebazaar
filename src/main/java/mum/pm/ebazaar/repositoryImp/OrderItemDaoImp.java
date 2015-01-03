package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.domain.OrderItem;
import mum.pm.ebazaar.repository.CategoryDao;
import mum.pm.ebazaar.repository.OrderItemDao;
import org.springframework.stereotype.Repository;
@Repository
public class OrderItemDaoImp extends GenericHibernateDaoImpl<OrderItem, Long> implements OrderItemDao {

}
