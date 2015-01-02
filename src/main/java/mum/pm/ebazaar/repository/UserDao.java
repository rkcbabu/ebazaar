package mum.pm.ebazaar.repository;

import java.util.List;
import mum.pm.ebazaar.domain.User;

public interface UserDao {
    
    public void saveUser(User user);
    public void deleteUser(int id);
    public List<User> listAllUsers();
    public User getUserById(int id);
    public User getUserByUsername(String username);
//    public User getUserByVerification(String code);
}
