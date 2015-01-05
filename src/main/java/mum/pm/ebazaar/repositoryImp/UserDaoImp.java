package mum.pm.ebazaar.repositoryImp;

import java.util.List;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.repository.UserDao;
import mum.pm.ebazaar.util.SessionUtil;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp extends GenericHibernateDaoImpl<User, Long> implements UserDao {

  
}