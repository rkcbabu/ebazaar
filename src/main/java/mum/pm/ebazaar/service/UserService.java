package mum.pm.ebazaar.service;

import java.util.List;
import mum.pm.ebazaar.domain.User;

public interface UserService {

    public List<User> getAll();

    public void create(User user);

    public void update(User user);
    
    public void updateAddress(User user);

    public void delete(User user);

    public User findById(long id);

    public User getUserByUsername(String username);

    public List<User> getVendors();

}
