package mum.pm.ebazaar.repositoryImp;

import java.util.List;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.repository.UserDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp extends GenericHibernateDaoImpl<User, Long> implements UserDao {

    @Override
    public List<User> getVendors() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.role = :urole");
        query.setParameter("urole", "ROLE_VENDOR");
        @SuppressWarnings("unchecked")
        List<User> users = query.list();
        return users;
    }
}
