package net.sf.brightside.travelsystem.service.facade;

import java.util.List;

import net.sf.brightside.travelsystem.metamodel.Reservation;

public interface SearchFlights {

	public List<Reservation> searchFlights(Reservation reservation);

}
