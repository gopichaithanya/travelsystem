package net.sf.brightside.travelsystem.service.facade.hibernate;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.service.facade.CancelReservation;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.ReservationValidationException;

public class CancelReservationImpl implements CancelReservation {

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

	private boolean validateReservation(Reservation reservation)
			throws ReservationValidationException {

		if (reservation.getCabinClass() == null
				|| reservation.getFlight() == null
				|| reservation.getReservationTime() == null
				|| reservation.getMeal() == null
				|| reservation.getPassenger() == null
				|| reservation.getSeat() == null) {
			throw new ReservationValidationException();

		}
		return true;

	}

	@Override
	public void cancelReservation(Reservation reservation)
			throws ReservationValidationException

	{
		// TODO Auto-generated method stub

		validateReservation(reservation);
		reservation.setReservationTime(null);
		reservation.setReserved(false);
		reservation.setMeal(null);
		reservation.setPassenger(null);

		persistenceManager.saveOrUpdate(reservation);

	}

}
