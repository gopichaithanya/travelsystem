package net.sf.brightside.travelsystem.service.facade;

import java.util.List;

import net.sf.brightside.travelsystem.metamodel.Airline;
import net.sf.brightside.travelsystem.metamodel.Airport;
import net.sf.brightside.travelsystem.metamodel.CabinClass;
import net.sf.brightside.travelsystem.metamodel.City;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Meal;
import net.sf.brightside.travelsystem.metamodel.Plain;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.metamodel.Seat;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.CanNotAddSeatException;

public interface AdministrationService {

	void addCity(City city);

	void addArline(Airline airline);

	void addCabinClass(CabinClass cabinClass);

	void addAirport(Airport airport);

	void createFlight(Flight flight);

	void createReservation(Reservation reservation);

	void addMeal(Meal meal);

	void addPlain(Plain plain);

	void addSeat(Seat seat) throws CanNotAddSeatException;

	List<Seat> getAvailableSeats(Flight flight);

	List<Reservation> returnReservationsForFlight(Flight flight);

	public List<Seat> getAllSeatsForPlain(Plain plain);

}
