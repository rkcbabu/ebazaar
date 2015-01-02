package mum.pm.ebazaar.service;

import java.util.List;


import mum.pm.ebazaar.domain.Card;

public interface CardService {
	Card create(Card card);  	
	Card read(long cardId);	
	void update(long cardId, Card card);
		
		void delete(int cardId);
		
		public List<Card> findAll();


}
