package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.domain.Payment;
import mum.pm.ebazaar.repository.CategoryDao;
import mum.pm.ebazaar.repository.PaymentDao;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImp extends GenericHibernateDaoImpl<Payment, Long> implements PaymentDao {

}
