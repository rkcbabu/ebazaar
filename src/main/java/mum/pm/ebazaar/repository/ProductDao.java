package mum.pm.ebazaar.repository;

import java.util.List;
import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.domain.User;

public interface ProductDao extends GenericDAO<Product, Long> {

    public List<Product> productsByKey(String key);

}
