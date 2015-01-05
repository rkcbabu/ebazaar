package mum.pm.ebazaar.serviceImp;

import java.util.List;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.repository.UserDao;
import mum.pm.ebazaar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;
    
    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

//    @Override
//    public User getUserByVerification(String code) {
//        return userDao.getUserByVerification(code);
//    }

    @Override
    public void update(User user) {
        User exisUser = userDao.get(user.getId());
        exisUser.setAddress(user.getAddress());
        exisUser.setUsername(user.getUsername());
        exisUser.setEmail(user.getEmail());
        exisUser.setFirstName(user.getFirstName());
        exisUser.setLastName(user.getLastName());
        exisUser.setPhone(user.getPhone());
        
        userDao.update(exisUser);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findById(long id) {
        return userDao.get(id);
    }
    
}