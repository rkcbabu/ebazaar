package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.repository.CategoryDao;
import mum.pm.ebazaar.repository.CustomerDao;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDaoImp extends GenericHibernateDaoImpl<Customer, Long> implements CustomerDao {

}
