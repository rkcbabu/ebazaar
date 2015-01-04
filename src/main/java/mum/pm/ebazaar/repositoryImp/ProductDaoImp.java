package mum.pm.ebazaar.repositoryImp;

import org.springframework.stereotype.Repository;

import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.repository.CardDao;
import mum.pm.ebazaar.repository.ProductDao;

@Repository
public class ProductDaoImp extends GenericHibernateDaoImpl<Product, Long> implements ProductDao{


}