package mum.pm.ebazaar.service;

import java.util.List;

import mum.pm.ebazaar.domain.Admin;



public interface AdminService {
	
	Admin create(Admin admin);

	Admin read(long adminId);

	void update(long adminId, Admin admin);

	void delete(int adminId);

	public List<Admin> findAll();

}
