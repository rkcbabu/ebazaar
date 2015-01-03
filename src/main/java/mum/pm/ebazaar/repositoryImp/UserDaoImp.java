package mum.pm.ebazaar.repositoryImp;

import java.util.List;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.repository.UserDao;
import mum.pm.ebazaar.util.SessionUtil;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp extends SessionUtil implements UserDao {

    @Override
    public void saveUser(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        if(user != null) getSession().delete(user);
    }

    @Override
    public List<User> listAllUsers() {
        return getSession().createQuery("FROM User").list();
    }

    @Override
    public User getUserById(int id) {
        return (User) getSession().get(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        return (User) getSession().createQuery("SELECT u FROM User u WHERE u.username = ?").setParameter(0, username).uniqueResult();
    }

//    @Override
//    public User getUserByVerification(String code) {
//        return (User) getSession().createQuery("SELECT u FROM User u WHERE u.verification = ?").setParameter(0, code).uniqueResult();
//    }
    
}
//public class UserDaoImp extends GenericHibernateDaoImpl<User, Long> implements UserDao {
//
//}
