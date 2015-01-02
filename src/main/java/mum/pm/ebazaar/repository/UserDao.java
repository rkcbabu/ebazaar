package mum.pm.ebazaar.repository;


import mum.pm.ebazaar.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {

}
