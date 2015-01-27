package mum.ea.myfinance.daoImpl;

import mum.ea.myfinance.domain.dao.FinanceDao;
import mum.ea.myfinance.domain.Finance;
import org.springframework.stereotype.Repository;

@Repository
public class FinanceDaoImpl extends GenericHibernateDaoImpl<Finance, Long>implements FinanceDao {

//    @Autowired
////    @Qualifier(value = "sessionFactory")
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void saveFinance(Finance finance) {
////        getSession().save(finance);
//        getSession().merge(finance);
//
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<Finance> listFinances() {
//        return getSession().createCriteria(Finance.class).list();
//    }
//
//    @Override
//    public Finance getFinance(Long id) {
//        return (Finance) getSession().get(Finance.class, id);
//    }
//
//    @Override
//    public void deleteFinance(Long id) {
//
//        Finance finance = getFinance(id);
//
//        if (null != finance) {
//            getSession().delete(finance);
//        }
//
//    }
//
//    private Session getSession() {
//        Session sess = getSessionFactory().getCurrentSession();
//        if (sess == null) {
//            sess = getSessionFactory().openSession();
//        }
//        return sess;
//    }
//    
//    private SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    @Override
//    public void save(Finance finance) {
//        getSession().save(finance);
//    }
}
