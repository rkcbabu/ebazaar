package mum.pm.ebazaar.serviceImp;

import java.util.List;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.repository.UserDao;
import mum.pm.ebazaar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;
    
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

//    @Override
//    public User getUserByVerification(String code) {
//        return userDao.getUserByVerification(code);
//    }
    
}

//@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW)
//
//public class UserServiceImp implements UserService {
//	
//	@Autowired
//    private UserDao userDao;
//
//	@Override
//	public List<User> getAll() {
//		List<User> listUser = userDao.getAll();
//		return listUser;
//	}
//
//	@Override
//	public void create(User user) {
//	
//		userDao.create(user);
//	}
//
//	@Override
//	public void update(User user) {
//		userDao.update(user);
//		
//	}
//
//	@Override
//	public void delete(User user) {
//		userDao.delete(user);
//		
//	}
//
//}
