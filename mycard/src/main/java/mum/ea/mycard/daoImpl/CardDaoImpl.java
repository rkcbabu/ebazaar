package mum.ea.mycard.daoImpl;

import mum.ea.mycard.domain.dao.CardDao;
import mum.ea.mycard.domain.Card;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional 
public class CardDaoImpl implements CardDao {

    @Autowired
//    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    public void saveCard(Card card) {
        getSession().merge(card);

    }

    @SuppressWarnings("unchecked")
    public List<Card> listCards() {
        return getSession().createCriteria(Card.class).list();
    }

    public Card getCard(Long id) {
        return (Card) getSession().get(Card.class, id);
    }

    public void deleteCard(Long id) {

        Card card = getCard(id);

        if (null != card) {
            getSession().delete(card);
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
