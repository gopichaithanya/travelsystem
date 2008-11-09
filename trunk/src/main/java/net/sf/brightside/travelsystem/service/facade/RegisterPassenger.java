package net.sf.brightside.travelsystem.service.facade;

import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.PassengerAlreadyExistsException;

public interface RegisterPassenger {

	void registerPassenger(Passenger passenger)
			throws PassengerAlreadyExistsException;

}
