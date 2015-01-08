package mum.pm.ebazaar.repositoryImp;

import java.util.List;
import mum.pm.ebazaar.domain.Category;
import org.springframework.stereotype.Repository;

import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.repository.ProductDao;
import org.hibernate.Query;

@Repository
public class ProductDaoImp extends GenericHibernateDaoImpl<Product, Long> implements ProductDao{

    @Override
    public List<Product> productsByKey(String key) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Product p WHERE p.name like :pname");
        query.setParameter("pname", "%"+key+"%");
        @SuppressWarnings("unchecked")
        List<Product> products = query.list();
        return products;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}