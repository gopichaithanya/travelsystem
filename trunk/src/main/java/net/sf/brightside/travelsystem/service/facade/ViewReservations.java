package net.sf.brightside.travelsystem.service.facade;

import java.util.List;

import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;

public interface ViewReservations {

	public List<Reservation> returnAllReservations(Passenger passenger);

}
