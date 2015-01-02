package mum.pm.ebazaar.serviceImp;

import java.util.List;

import mum.pm.ebazaar.domain.Admin;
import mum.pm.ebazaar.repository.AdminDao;
import mum.pm.ebazaar.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class AdminServiceImp implements AdminService {
	
	
	@Autowired
	private AdminDao  adminDao;

	@Override
	public Admin create(Admin admin) {
		adminDao.save(admin);
		return admin;
	}

	@Override
	public Admin read(long adminId) {
		Admin admin = adminDao.findOne(adminId);
		return admin;
	}

	@Override
	public void update(long adminId, Admin admin) {
		 List<Admin> listAdmin = (List<Admin>)adminDao.findAll();
				
	}

	@Override
	public void delete(int adminId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> findAll() {
		List<Admin> listAdmin = (List<Admin>)adminDao.findAll();
		return listAdmin;	
		}

}
