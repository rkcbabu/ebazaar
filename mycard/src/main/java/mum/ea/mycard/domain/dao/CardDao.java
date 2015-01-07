package mum.ea.mycard.domain.dao;

import mum.ea.mycard.domain.Card;
import java.util.List;

public interface CardDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveCard(Card book); // create and update

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
