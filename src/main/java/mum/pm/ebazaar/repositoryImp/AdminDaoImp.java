package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Admin;
import mum.pm.ebazaar.repository.AdminDao;

import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImp extends GenericHibernateDaoImpl<Admin, Long> implements AdminDao
{   
	
}
