package net.sf.brightside.travelsystem.service.facade.hibernate;

import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.RegisterPassenger;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.PassengerAlreadyExistsException;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class RegisterPassengerImpl implements RegisterPassenger {
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
	public void registerPassenger(Passenger passenger)
			throws PassengerAlreadyExistsException {
		// TODO Auto-generated method stub
		if (passenger.get_id() == null) {
			this.checkUsernameAndPassoword(passenger);
		}

		this.getPersistenceManager().saveOrUpdate(passenger);

	}

	@SuppressWarnings("unchecked")
	@Transactional
	private void checkUsernameAndPassoword(Passenger passenger)
			throws PassengerAlreadyExistsException {
		DetachedCriteria dcriteria = DetachedCriteria.forClass(Passenger.class);

		dcriteria.add(Restrictions.eq("username", passenger.getUsername()));
		dcriteria.add(Restrictions.eq("password", passenger.getPassword()));
		List<Passenger> list = this.getPersistenceManager()
				.executeDetachedCriteria(Passenger.class, dcriteria);
		if (list.size() > 0) {
			throw new PassengerAlreadyExistsException();
		}

	}

}
