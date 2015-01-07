package mum.ea.myfinance.daoImpl;

import mum.ea.myfinance.domain.dao.FinanceDao;
import mum.ea.myfinance.domain.Finance;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional 
public class FinanceDaoImpl implements FinanceDao {

    @Autowired
//    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    public void saveFinance(Finance finance) {
        getSession().merge(finance);

    }

    @SuppressWarnings("unchecked")
    public List<Finance> listFinances() {
        return getSession().createCriteria(Finance.class).list();
    }

    public Finance getFinance(Long id) {
        return (Finance) getSession().get(Finance.class, id);
    }

    public void deleteFinance(Long id) {

        Finance finance = getFinance(id);

        if (null != finance) {
            getSession().delete(finance);
        }

    }

    private Session getSession() {
        Session sess = getSessionFactory().getCurrentSession();
        if (sess == null) {
            sess = getSessionFactory().openSession();
        }
        return sess;
    }
    
    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
