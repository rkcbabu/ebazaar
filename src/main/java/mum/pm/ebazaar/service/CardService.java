package mum.pm.ebazaar.service;

import java.util.List;



import mum.pm.ebazaar.domain.Card;

public interface CardService {
	
	public Card get(long id);

	public List<Card> getAll();

	public void create(Card card);
	
	public void update(Card card);
	
	public void delete(Card card);


}
