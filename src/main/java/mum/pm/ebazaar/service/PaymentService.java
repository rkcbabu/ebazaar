package mum.pm.ebazaar.service;

import java.util.List;

import mum.pm.ebazaar.domain.Order;
import mum.pm.ebazaar.domain.Payment;

public interface PaymentService {
	
	public List<Payment> getAll();

	public void create(Payment payment);
	
	public void update(Payment payment);
	
	public void delete(Payment payment);

}
