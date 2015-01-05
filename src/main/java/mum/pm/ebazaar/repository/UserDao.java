package mum.pm.ebazaar.repository;

import java.util.List;
import mum.pm.ebazaar.domain.User;

public interface UserDao  extends GenericDAO<User, Long> {

    public User findByUsername(String username);
}
