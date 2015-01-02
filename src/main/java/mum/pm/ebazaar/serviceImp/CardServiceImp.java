package mum.pm.ebazaar.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.repository.CardDao;
import mum.pm.ebazaar.service.CardService;

public class CardServiceImp implements CardService {
	
	@Autowired
	private CardDao cardDao;

	@Override
	public Card create(Card card) {
		cardDao.save(card);
		return card;
	}

	@Override
	public Card read(long cardId) {
		Card card = cardDao.findOne(cardId);
		return card;
	}

	@Override
	public void update(long cardId, Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int cardId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Card> findAll() {
		List<Card> listCard = (List<Card>)cardDao.findAll();
		return listCard;
	}

}
