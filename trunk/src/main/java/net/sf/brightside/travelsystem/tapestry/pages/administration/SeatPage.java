package net.sf.brightside.travelsystem.tapestry.pages.administration;

import java.util.ArrayList;
import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Plain;
import net.sf.brightside.travelsystem.metamodel.Seat;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.CanNotAddSeatException;
import net.sf.brightside.travelsystem.tapestry.pages.Login;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;
import net.sf.brightside.travelsystem.tapestry.util.BeanEncoder;
import net.sf.brightside.travelsystem.tapestry.util.BeanSelectModel;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.corelib.components.Submit;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.context.ApplicationContext;

public class SeatPage {
	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;

	private boolean seatViewButtonPressed = false;

	@Persist(value = "flash")
	private String message;

	private Seat seat;

	@Persist
	private Plain plain;

	public Plain getPlain() {
		return plain;
	}

	public void setPlain(Plain plain) {
		this.plain = plain;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
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

	private Integer seatNumber;

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	@SuppressWarnings("unchecked")
	public List<Seat> getSeats() {
		if (getPlain() != null) {
			return admins.getAllSeatsForPlain(getPlain());
		}

		return new ArrayList<Seat>();
	}

	@SuppressWarnings("unchecked")
	public SelectModel getPlains() {

		List<Plain> plains = persistenceManager.get(Plain.class);

		return new BeanSelectModel<Plain>(plains);
	}

	public ValueEncoder<Plain> getPlainEncoder() {
		return new BeanEncoder<Plain>(persistenceManager, Plain.class);
	}

	@OnEvent(component = "seatform", value = "submit")
	public Object onSubmitForm() {

		if (!seatViewButtonPressed && this.getPlain() != null) {

			if (this.getSeatNumber() == null) {
				this.setMessage("Enter seat number");
				seatViewButtonPressed = false;
				return null;
			}
			Seat a = (Seat) context.getBean(Seat.class.getName());

			a.setNumber(getSeatNumber());
			a.setPlain(getPlain());

			try {
				admins.addSeat(a);
			} catch (CanNotAddSeatException e) {
				// TODO Auto-generated catch block
				this.setMessage("Plain can't have two seats with same number.");
				seatViewButtonPressed = false;
			}
			seatViewButtonPressed = false;
		}

		return null;

	}

	@SuppressWarnings("unchecked")
	@OnEvent(component = "deleteseat")
	public Object onDeleteLink(Long id) {

		Object object = persistenceManager.get(Seat.class, id);

		persistenceManager.delete(object);
		return null;

	}

	private Submit viewseats;

	public Submit getViewseats() {
		return viewseats;
	}

	public void setViewseats(Submit viewseats) {
		this.viewseats = viewseats;
	}

	@OnEvent(component = "viewseats")
	public void viewSeatPressed() {

		this.seatViewButtonPressed = true;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
