package net.sf.brightside.travelsystem.tapestry.pages.administration;

import java.util.Date;
import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Airline;
import net.sf.brightside.travelsystem.metamodel.Airport;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Plain;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;
import net.sf.brightside.travelsystem.tapestry.pages.Login;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;
import net.sf.brightside.travelsystem.tapestry.util.BeanEncoder;
import net.sf.brightside.travelsystem.tapestry.util.BeanSelectModel;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.context.ApplicationContext;

public class FlightCreation {
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
	private Airline airline;
	private Plain plain;

	private Date departureDate;
	private Date arrivalDate;

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
	public ValueEncoder getPlainEncoder() {
		return new BeanEncoder<Plain>(persistenceManager, Plain.class);
	}

	@SuppressWarnings("unchecked")
	public SelectModel getPlains() {

		List<Plain> airports = persistenceManager.get(Plain.class);

		return new BeanSelectModel<Plain>(airports);

	}

	@SuppressWarnings("unchecked")
	public ValueEncoder getAirportEncoder() {
		return new BeanEncoder<Airport>(persistenceManager, Airport.class);
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

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getFlights() {
		return persistenceManager.get(Flight.class);
	}

	private Flight flight;

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Inject
	private ApplicationContext context;

	@Inject
	@SpringBean
	private AdministrationService service;

	private Integer flightNumber;

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	@OnEvent(component = "flightcreationform")
	Object onSubmitSearchFlight() {

		Flight flight = (Flight) context.getBean(Flight.class.getName());

		flight.setDepartureAirport(getDepartureAirport());
		flight.setArrivalAirport(getArrivalAirport());
		flight.setDepartureTime(getDepartureDate());
		flight.setArrivalTime(getArrivalDate());
		flight.setAirline(getAirline());
		flight.setPlain(getPlain());

		flight.setNumber(getFlightNumber());
		service.createFlight(flight);

		return null;
	}

	@SuppressWarnings("unchecked")
	@OnEvent(component = "deleteflight")
	Object onDeleteFlight(Long id) {

		Object object = persistenceManager.get(Flight.class, id);
		persistenceManager.delete(object);

		return null;
	}

	public Plain getPlain() {
		return plain;
	}

	public void setPlain(Plain plain) {
		this.plain = plain;
	}

}
