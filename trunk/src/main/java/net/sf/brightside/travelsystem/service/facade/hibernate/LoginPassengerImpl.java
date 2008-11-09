package net.sf.brightside.travelsystem.service.facade.hibernate;

import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.LoginPassenger;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class LoginPassengerImpl implements LoginPassenger {

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Passenger login(Passenger passenger) {
		// TODO Auto-generated method stub

		DetachedCriteria dcriteria = DetachedCriteria.forClass(Passenger.class);

		dcriteria.add(Restrictions.eq("username", passenger.getUsername()));
		dcriteria.add(Restrictions.eq("password", passenger.getPassword()));

		List<Passenger> list = this.getPersistenceManager()
				.executeDetachedCriteria(Passenger.class, dcriteria);

		System.out.println(list);

		if (list.size() > 0) {
			return list.get(0);
		}

		else {
			return null;
		}

	}
}
