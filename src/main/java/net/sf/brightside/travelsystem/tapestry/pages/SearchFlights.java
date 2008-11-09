package net.sf.brightside.travelsystem.tapestry.pages;

import java.util.Date;
import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Airline;
import net.sf.brightside.travelsystem.metamodel.Airport;
import net.sf.brightside.travelsystem.metamodel.CabinClass;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;
import net.sf.brightside.travelsystem.tapestry.util.BeanEncoder;
import net.sf.brightside.travelsystem.tapestry.util.BeanSelectModel;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.annotations.Inject;

public class SearchFlights {
	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;

	public Object onActivate() {

		if (!passengerExists) {
			return Login.class;
		} else {
			return null;
		}
	}

	private Airport departureAirport;
	private Airport arrivalAirport;
	private CabinClass cabinClass;
	private Airline airline;

	private Date departureDate;

	@SuppressWarnings("unchecked")
	@Inject
	@SpringBean
	private PersistenceManager persistenceManager;

	@SuppressWarnings("unchecked")
	public SelectModel getAirports() {

		List<Airport> airports = persistenceManager.get(Airport.class);

		return new BeanSelectModel<Airport>(airports);

	}

	@SuppressWarnings("unchecked")
	public ValueEncoder getAirportEncoder() {
		return new BeanEncoder<Airport>(persistenceManager, Airport.class);
	}

	@SuppressWarnings("unchecked")
	public SelectModel getCabinClasses() {

		List<CabinClass> cc = persistenceManager.get(CabinClass.class);

		return new BeanSelectModel<CabinClass>(cc);

	}

	@SuppressWarnings("unchecked")
	public ValueEncoder getCabinClassEncoder() {
		return new BeanEncoder<CabinClass>(persistenceManager, CabinClass.class);
	}

	@SuppressWarnings("unchecked")
	public SelectModel getAirlines() {

		List<Airline> ar = persistenceManager.get(Airline.class);

		return new BeanSelectModel<Airline>(ar);

	}

	@SuppressWarnings("unchecked")
	public ValueEncoder getAirlineEncoder() {
		return new BeanEncoder<Airline>(persistenceManager, Airline.class);
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public boolean isPassengerExists() {
		return passengerExists;
	}

	public void setPassengerExists(boolean passengerExists) {
		this.passengerExists = passengerExists;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departurAirport) {
		this.departureAirport = departurAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public CabinClass getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(CabinClass cabinClass) {
		this.cabinClass = cabinClass;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	@InjectPage
	private Flights flights;
	@Inject
	@SpringBean
	private Reservation reservation;
	@Inject
	@SpringBean
	private Flight flight;

	@OnEvent(component = "searchform")
	Object onSubmitSearchFlight() {
		reservation.setCabinClass(getCabinClass());
		flight.setDepartureAirport(getDepartureAirport());
		flight.setArrivalAirport(getArrivalAirport());
		flight.setDepartureTime(getDepartureDate());
		flight.setAirline(getAirline());

		reservation.setFlight(flight);

		flights.setReservationToSearch(reservation);
		return flights;
	}
}
