package mum.pm.ebazaar.service;

import java.util.List;

import mum.pm.ebazaar.domain.Admin;



public interface AdminService {
	
	public Admin get(long id);

	public List<Admin> getAll();

	public void create(Admin entity);
	
	public void update(Admin entity);
	
	public void delete(Admin entity);

}
