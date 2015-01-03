package mum.pm.ebazaar.serviceImp;

import java.util.List;

import mum.pm.ebazaar.domain.Admin;
import mum.pm.ebazaar.repository.AdminDao;
import mum.pm.ebazaar.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AdminServiceImp implements AdminService {
	
	@Autowired
    private AdminDao adminDao;

	@Override
	public Admin get(long id) {
		Admin admin =adminDao.get(id);
		return admin;
	}

	@Override
	public List<Admin> getAll() {
		List<Admin> listAdmin = adminDao.getAll();
		return listAdmin;
	}

	@Override
	public void create(Admin admin) {
		adminDao.create(admin);
		
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin entity) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
