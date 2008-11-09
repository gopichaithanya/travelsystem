package net.sf.brightside.travelsystem.service.facade;

import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.ReservationValidationException;

public interface CancelReservation {

	void cancelReservation(Reservation reservation)
			throws ReservationValidationException;
}
