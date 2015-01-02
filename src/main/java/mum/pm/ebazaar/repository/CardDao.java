package mum.pm.ebazaar.repository;


import mum.pm.ebazaar.domain.Card;

import org.springframework.data.repository.CrudRepository;

public interface CardDao extends CrudRepository<Card,Long> {

}
