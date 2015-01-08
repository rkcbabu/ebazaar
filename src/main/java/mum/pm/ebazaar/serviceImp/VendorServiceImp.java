package mum.pm.ebazaar.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.domain.Vendor;
import mum.pm.ebazaar.repository.UserDao;
import mum.pm.ebazaar.repository.VendorDao;
import mum.pm.ebazaar.service.VendorService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class VendorServiceImp implements VendorService{
	
	@Autowired
    private VendorDao vendordao;

	@Override
	public List<Vendor> getAll() {
		List<Vendor> listVendor = vendordao.getAll();
		return listVendor;
	}

	@Override
	public void create(Vendor vendor) {
		vendordao.create(vendor);
		
	}


	@Override
	public void update(Vendor vendor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Vendor vendor) {
		// TODO Auto-generated method stub
		
	}
	
	
}
