package mum.ea.myfinance.serviceImpl;

import mum.ea.myfinance.domain.dao.FinanceDao;
import mum.ea.myfinance.domain.Finance;
import java.util.List;
import mum.ea.myfinance.service.FinanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class FinanceServiceImpl implements FinanceService{

	@Autowired
	private FinanceDao financeDao;

	@Transactional
        @Override
	public void saveFinance(Finance finance) {
		financeDao.create(finance);
	}

	@Transactional(readOnly = true)
        @Override
	public List<Finance> listFinances() {
		return financeDao.getAll();
	}

	@Transactional(readOnly = true)
        @Override
	public Finance getFinance(Long id) {
		return financeDao.get(id);
	}

	@Transactional
        @Override
	public void deleteFinance(Long id) {
		financeDao.deleteById(id);

	}

    @Override
    public void save(Finance finance) {
//        financeDao.save(finance);
        financeDao.create(finance);
    }

}
