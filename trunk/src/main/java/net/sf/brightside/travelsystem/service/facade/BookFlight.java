package net.sf.brightside.travelsystem.service.facade;

import net.sf.brightside.travelsystem.core.CreditCard;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.ReservationValidationException;

public interface BookFlight {

	void bookFlight(Reservation reservation, CreditCard creditCard)
			throws ReservationValidationException;

}
