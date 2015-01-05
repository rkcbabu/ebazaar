package mum.pm.ebazaar.serviceImp;

import mum.pm.ebazaar.domain.Address;
import mum.pm.ebazaar.service.AddressService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AddressServiceImp implements AddressService {

	@Override
	public Address get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Address address) {
		// TODO Auto-generated method stub
		
	}

	

}
