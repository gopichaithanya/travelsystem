package net.sf.brightside.travelsystem.tapestry.pages;

import java.util.List;

import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 * @author Nikola
 * 
 */
public class Flights {
	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;

	@InjectPage
	private InfoPage infopage;

	Object onActivate() {

		if (!passengerExists) {
			return Login.class;
		} else if (reservationToSearch == null) {
			infopage
					.setMessage("Go to search page and enter some criteria to search.");
			return infopage;
		} else {
			return null;
		}

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

	@Persist()
	private Reservation reservationToSearch;

	@Inject
	@SpringBean
	private net.sf.brightside.travelsystem.service.facade.SearchFlights searchFlights;

	@Persist(value = "flash")
	private String infoAboutReservations;

	public String getInfoAboutReservations() {
		return infoAboutReservations;
	}

	public void setInfoAboutReservations(String infoAboutReservations) {
		this.infoAboutReservations = infoAboutReservations;
	}

	public List<Reservation> getReservations()

	{
		List<Reservation> list = searchFlights
				.searchFlights(reservationToSearch);

		if (list.size() == 0) {
			this
					.setInfoAboutReservations("There are no available flights match criteria");
		}

		return list;

	}

	private Reservation reservation;

	@InjectPage
	private FlightDetails flightDetails;

	@OnEvent(component = "bookflight")
	public Object onBookFlightEvent(Long id) {

		Reservation r = null;
		List<Reservation> reslist = this.getReservations();
		for (Reservation reservation : reslist) {
			if (reservation.getFlight().get_id().equals(id)) {
				r = reservation;
			}
		}
		flightDetails.setReservation(r);
		return flightDetails;
	}

	public Reservation getReservationToSearch() {
		return reservationToSearch;
	}

	public void setReservationToSearch(Reservation reservationToSearch) {
		this.reservationToSearch = reservationToSearch;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
