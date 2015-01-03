package mum.pm.ebazaar.serviceImp;

import java.util.List;

import mum.pm.ebazaar.domain.Payment;
import mum.pm.ebazaar.repository.OrderItemDao;
import mum.pm.ebazaar.repository.PaymentDao;
import mum.pm.ebazaar.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)

public class PaymentServiceImp implements PaymentService {
	
	@Autowired
    private PaymentDao paymentDao;

	@Override
	public List<Payment> getAll() {
		List<Payment> paymentlist = paymentDao.getAll();
		return paymentlist;
	}

	@Override
	public void create(Payment payment) {
		
		paymentDao.create(payment);
	}

	@Override
	public void update(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Payment payment) {
		// TODO Auto-generated method stub
		
	}

}
