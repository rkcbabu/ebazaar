package mum.ea.myfinance.service;

import java.util.List;
import mum.ea.myfinance.domain.Finance;


public interface FinanceService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveFinance(Finance finance);
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
