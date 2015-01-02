package mum.pm.ebazaar.repository;

import mum.pm.ebazaar.domain.Address;
import mum.pm.ebazaar.domain.Admin;

import org.springframework.data.repository.CrudRepository;

public interface AddressDao  extends CrudRepository<Address,Long>{

}
