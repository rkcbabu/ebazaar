package mum.pm.ebazaar.service;

import java.util.List;

import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.domain.Vendor;



public interface VendorService {
	
	public List<Vendor> getAll();

	public void create(Vendor vendor);
	
	public void update(Vendor vendor);
	
	public void delete(Vendor vendor);

	

}
