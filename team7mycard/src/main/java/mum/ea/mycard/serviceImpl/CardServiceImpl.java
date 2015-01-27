package mum.ea.mycard.serviceImpl;

import mum.ea.mycard.domain.dao.CardDao;
import mum.ea.mycard.domain.Card;
import java.util.List;
import mum.ea.mycard.service.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardDao cardDao;

	@Transactional
	public void saveCard(Card card) {
		cardDao.saveCard(card);
	}

	@Transactional(readOnly = true)
	public List<Card> listCards() {
		return cardDao.listCards();
	}

	@Transactional(readOnly = true)
	public Card getCard(Long id) {
		return cardDao.getCard(id);
	}

	@Transactional
	public void deleteCard(Long id) {
		cardDao.deleteCard(id);

	}
        
        public Card findByCCNO(String ccno){
            return cardDao.findByCCNO(ccno);
        }

}
