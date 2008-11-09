package net.sf.brightside.travelsystem.tapestry.pages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.brightside.travelsystem.core.CreditCard;
import net.sf.brightside.travelsystem.core.beans.CreditCardBean;
import net.sf.brightside.travelsystem.core.beans.CreditCardType;
import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Meal;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.service.facade.BookFlight;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.ReservationValidationException;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;
import net.sf.brightside.travelsystem.tapestry.util.BeanEncoder;
import net.sf.brightside.travelsystem.tapestry.util.BeanSelectModel;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;

public class FlightDetails {

	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;
	@Validate("required")
	private String creditCardType = "visa";
	@Validate("required")
	private Integer cardNumber;

	@Validate("required")
	private Integer cardVerificationCode;
	@Validate("required")
	private String nameOnCard;

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
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

	Object onActivate() {
		if (passenger == null) {
			return Login.class;
		}
		if (this.getReservation() == null) {

			infopage
					.setMessage("In order to book flight you must choose one first!");
			return infopage;
		} else {
			return null;
		}
	}

	@InjectPage
	private InfoPage infopage;

	@Persist
	private Reservation reservation;

	public List<Reservation> getReservations()

	{
		List<Reservation> list = new ArrayList<Reservation>();
		list.add(getReservation());

		return list;

	}

	@SuppressWarnings("unchecked")
	@Inject
	@SpringBean
	private PersistenceManager pm;

	@SuppressWarnings("unchecked")
	public SelectModel getMeals() {

		List<Meal> list = pm.get(Meal.class);
		return new BeanSelectModel<Meal>(list);

	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	private Meal meal;

	@Inject
	@SpringBean
	private BookFlight bookFlight;

	@OnEvent(component = "bookflightform")
	public Object onBookFlighEvent() {

		this.getReservation().setMeal(getMeal());
		this.getReservation().setPassenger(getPassenger());
		this.getReservation().setReservationTime(new Date());

		CreditCard card = new CreditCardBean();
		card.setCardNumber(getCardNumber().toString());
		card.setCardVerificationCode(getCardVerificationCode().toString());
		card.setNameOnCard(getNameOnCard());
		if (getCreditCardType().equals("visa")) {
			card.setCreditCardType(CreditCardType.VISA);
		}
		if (getCreditCardType().equals("mastercard")) {
			card.setCreditCardType(CreditCardType.MASTER_CARD);
		}

		if (getCreditCardType().equals("americaexpress")) {
			card.setCreditCardType(CreditCardType.AMERICAN_EXPRESS);
		}

		try {
			bookFlight.bookFlight(getReservation(), card);
		} catch (ReservationValidationException e) {
			// TODO Auto-generated catch block
			infopage.setMessage("Error validating reservation data.");
			return infopage;
		}

		infopage
				.setMessage("Cangradulations! You have succesfully booked flight. Have a pleasent flight.");
		return infopage;
	}

	public ValueEncoder<Meal> getMealEncoder() {
		return new BeanEncoder<Meal>(pm, Meal.class);
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Integer getCardVerificationCode() {
		return cardVerificationCode;
	}

	public void setCardVerificationCode(Integer cardVerificationCode) {
		this.cardVerificationCode = cardVerificationCode;
	}

}
