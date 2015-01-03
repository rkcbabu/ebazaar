package mum.pm.ebazaar.service;

import java.util.List;

import mum.pm.ebazaar.domain.Address;
import mum.pm.ebazaar.domain.Admin;

public interface AddressService {
	public Address get(long id);

	//public List<Adm> getAll();

	public void create(Address address);
	
	public void update(Address address);
	
	public void delete(Address address);

}
