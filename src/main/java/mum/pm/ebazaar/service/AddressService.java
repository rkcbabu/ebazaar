package mum.pm.ebazaar.service;


import mum.pm.ebazaar.domain.Address;

public interface AddressService {
	public Address get(long id);

	//public List<Adm> getAll();

	public void create(Address address);
	
	public void update(Address address);
	
	public void delete(Address address);

}
