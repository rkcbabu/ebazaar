package mum.pm.ebazaar.service;

import java.util.List;
import mum.pm.ebazaar.domain.User;

public interface UserService {
    public void saveUser(User user);
    public void deleteUser(int id);
    public List<User> listAllUsers();
    public User getUserById(int id);
    public User getUserByUsername(String username);
//    public User getUserByVerification(String code);
}
