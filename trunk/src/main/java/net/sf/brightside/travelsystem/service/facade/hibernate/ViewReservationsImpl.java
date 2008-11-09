package net.sf.brightside.travelsystem.service.facade.hibernate;

import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.service.facade.ViewReservations;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class ViewReservationsImpl implements ViewReservations {
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
	public List<Reservation> returnAllReservations(Passenger passenger) {
		// TODO Auto-generated method stub

		DetachedCriteria dcriteria = DetachedCriteria
				.forClass(Reservation.class);
		dcriteria.add(Restrictions.eq("passenger", passenger));

		// String hql = "from ReservationBean as r where r.passenger=?";
		// List param = new ArrayList();
		// param.add(passenger);
		//
		// List<Reservation> list = this.getPersistenceManager().executeQuery(
		// Reservation.class, hql, param);

		List<Reservation> list = getPersistenceManager()
				.executeDetachedCriteria(Reservation.class, dcriteria);
		return list;
	}

}
