package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.repository.CustomerDao;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDaoImp extends GenericHibernateDaoImpl<Customer, Long> implements CustomerDao {

   @Override
    public Customer getByUsername(String userName) {
        return (Customer) sessionFactory.getCurrentSession().createQuery("SELECT u FROM Customer u WHERE u.username = ?").setParameter(0, userName).uniqueResult();

    }
}
