package net.sf.brightside.travelsystem.service.facade.hibernate;

import net.sf.brightside.travelsystem.core.CreditCard;
import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.service.facade.Payment;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.PaymentErrorException;

import org.springframework.transaction.annotation.Transactional;

public class PaymentImpl implements Payment {

	@SuppressWarnings("unchecked")
	private PersistenceManager persistenceManager;

	@SuppressWarnings("unchecked")
	public PersistenceManager getPersistenceManager() {
		return persistenceManager;
	}

	@SuppressWarnings("unchecked")
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	@Override
	@Transactional
	public void chargeReservation(Reservation reservation, CreditCard card)
			throws PaymentErrorException {
		// TODO Auto-generated method stub
		// here goes some code that calls some other
		// services in order to execute money transaction

	}

}
