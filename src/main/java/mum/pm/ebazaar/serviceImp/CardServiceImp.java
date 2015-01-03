package mum.pm.ebazaar.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.repository.CardDao;
import mum.pm.ebazaar.service.CardService;
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CardServiceImp implements CardService {
	
	@Autowired
	private CardDao cardDao;

	@Override
	public Card get(long id) {
		Card card = cardDao.get(id);
		return card;
	}

	@Override
	public List<Card> getAll() {
		List<Card> listCard = cardDao.getAll();
		
		return listCard;
	}

	@Override
	public void create(Card card) {
	      
		cardDao.create(card);
	}

	@Override
	public void update(Card card) {
		cardDao.update(card);
		
	}

	@Override
	public void delete(Card card) {
		// TODO Auto-generated method stub
		
	}

	
}
