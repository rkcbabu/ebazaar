package mum.ea.mycard.service;

import mum.ea.mycard.domain.Card;
import java.util.List;


public interface CardService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveCard(Card book);

	/*
	 * READ
	 */
	public List<Card> listCards();
	public Card getCard(Long id);

	/*
	 * DELETE
	 */
	public void deleteCard(Long id);

}
