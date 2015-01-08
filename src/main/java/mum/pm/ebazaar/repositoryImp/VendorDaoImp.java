package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.domain.Vendor;
import mum.pm.ebazaar.repository.CategoryDao;
import mum.pm.ebazaar.repository.VendorDao;
import org.springframework.stereotype.Repository;

@Repository
public class VendorDaoImp extends GenericHibernateDaoImpl<Vendor, Long> implements VendorDao {

}
