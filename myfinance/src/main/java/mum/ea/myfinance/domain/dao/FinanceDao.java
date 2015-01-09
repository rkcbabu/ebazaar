package mum.ea.myfinance.domain.dao;

import java.util.List;
import mum.ea.myfinance.domain.Finance;

public interface FinanceDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveFinance(Finance finance); // create and update
        public void save(Finance finance);
	/*
	 * READ
	 */
	public List<Finance> listFinances();
	public Finance getFinance(Long id);

	/*
	 * DELETE
	 */
	public void deleteFinance(Long id);
}
