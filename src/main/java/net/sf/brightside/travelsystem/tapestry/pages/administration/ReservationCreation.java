package net.sf.brightside.travelsystem.tapestry.pages.administration;

import java.util.ArrayList;
import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.CabinClass;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.metamodel.Seat;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;
import net.sf.brightside.travelsystem.tapestry.pages.Login;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;
import net.sf.brightside.travelsystem.tapestry.util.BeanEncoder;
import net.sf.brightside.travelsystem.tapestry.util.BeanSelectModel;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.IncludeJavaScriptLibrary;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.context.ApplicationContext;

@IncludeJavaScriptLibrary("context:resources/script.js")
public class ReservationCreation {

	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;
	@Persist
	private CabinClass cabinClass;

	@Persist
	
	private Flight flight;

	private Seat seat;

	private Double price;

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public CabinClass getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(CabinClass cabinClass) {
		this.cabinClass = cabinClass;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Object onActivate() {

		if (!passengerExists) {
			return Login.class;
		} else {
			return null;
		}
	}

	@Inject
	@SpringBean
	private AdministrationService admins;

	@Inject
	@Service("MyApplicationContext")
	private ApplicationContext context;

	@SuppressWarnings("unchecked")
	@Inject
	@SpringBean
	private PersistenceManager persistenceManager;

	@SuppressWarnings("unchecked")
	public SelectModel getCabinClasses() {
		List<CabinClass> cabinClass = persistenceManager.get(CabinClass.class);

		return new BeanSelectModel<CabinClass>(cabinClass);
	}

	public ValueEncoder<Flight> getFlightEncoder() {
		return new BeanEncoder<Flight>(persistenceManager, Flight.class);
	}

	@SuppressWarnings("unchecked")
	public SelectModel getFlights() {
		List<Flight> flights = persistenceManager.get(Flight.class);

		return new BeanSelectModel<Flight>(flights);
	}

	public ValueEncoder<Seat> getSeatEncoder() {
		return new BeanEncoder<Seat>(persistenceManager, Seat.class);
	}

	@SuppressWarnings("unchecked")
	public SelectModel getSeats() {
		List<Seat> availableSeats = new ArrayList<Seat>();
		if (this.getFlight() != null) {

			availableSeats = admins.getAvailableSeats(getFlight());
		}

		return new BeanSelectModel<Seat>(availableSeats);
	}

	public ValueEncoder<CabinClass> getCabinClassEncoder() {
		return new BeanEncoder<CabinClass>(persistenceManager, CabinClass.class);
	}

	private boolean selectFlightBool = false;

	@OnEvent(component = "reservationform", value = "submit")
	public Object onSubmitForm() {

		if (this.getFlight() != null
				|| this.getSeats().getOptions().size() == 0) {
			if (this.getSeat() == null || this.getCabinClass() == null) {
				this.setMessage("Choose seat and cabinclass!");
				return null;
			}
			if (this.getPrice() == null) {
				this.setMessage("Enter reservation price.");
				return null;
			}
			if (!selectFlightBool) {
				Reservation res = (Reservation) context
						.getBean(Reservation.class.getName());
				res.setFlight(getFlight());
				res.setCabinClass(getCabinClass());
				res.setSeat(getSeat());
				res.setPrice(getPrice());
				res.setReserved(false);
				admins.createReservation(res);
				cleanup();

				return null;
			} else {
				selectFlightBool = false;
				return null;
			}

		} else {
			this.setMessage("No available seats for this flight.");
			return null;
		}

	}

	private void cleanup() {
		this.setSeat(null);
		this.setMessage(null);
		this.setPrice(null);
		this.setCabinClass(null);

	}

	@OnEvent(component = "submitflight")
	public void onSubmitedFlight() {
		this.selectFlightBool = true;

	}

	private Reservation reservation;

	@Persist(value = "flash")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@SuppressWarnings("unchecked")
	public List<Reservation> getReservations() {

		List<Reservation> reservations = new ArrayList<Reservation>();
		if (this.getFlight() != null) {
			reservations = admins.returnReservationsForFlight(getFlight());
		}

		return reservations;
	}

	@SuppressWarnings("unchecked")
	@OnEvent(component = "deletereservation")
	public Object onDeleteLink(Long id) {

		Object object = persistenceManager.get(Reservation.class, id);

		persistenceManager.delete(object);
		return null;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
