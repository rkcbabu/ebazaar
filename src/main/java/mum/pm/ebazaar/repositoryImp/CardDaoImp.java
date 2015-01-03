package mum.pm.ebazaar.repositoryImp;

import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.repository.CardDao;
import org.springframework.stereotype.Repository;
@Repository
public class CardDaoImp extends GenericHibernateDaoImpl<Card, Long> implements CardDao
{   
	
}
