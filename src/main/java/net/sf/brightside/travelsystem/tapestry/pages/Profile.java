package net.sf.brightside.travelsystem.tapestry.pages;

import java.util.Date;

import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.RegisterPassenger;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.PassengerAlreadyExistsException;
import net.sf.brightside.travelsystem.tapestry.pages.enums.Title;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

public class Profile {
	@ApplicationState
	private Passenger passenger;

	@Persist(value = "flash")
	private String message;

	@Inject
	private Messages messages;

	@Inject
	@SpringBean
	private RegisterPassenger registerPassenger;

	private String firstName = "";
	private String lastname = "";
	private Date dateOfBirth = null;
	private String username = "";
	private String password = "";

	Object onActivate() {
		if (!passengerExists) {
			return Login.class;
		} else {
			this.setFirstName(passenger.getFirstName());
			this.setLastname(passenger.getLastName());
			this.setDateOfBirth(passenger.getDateOfBirth());

			this.setUsername(passenger.getUsername());
			this.setPassword(passenger.getPassword());
			return null;
		}

	}

	private Title title;

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public SelectModel getTitles() {
		return new EnumSelectModel(Title.class, messages);
	}

	private boolean passengerExists;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public RegisterPassenger getRegisterPassenger() {
		return registerPassenger;
	}

	public void setRegisterPassenger(RegisterPassenger registerPassenger) {
		this.registerPassenger = registerPassenger;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private boolean checkFields() {

		if (this.getUsername().equals("") || this.getPassword().equals("")
				|| this.getLastname().equals("")
				|| this.getUsername().equals("")
				|| this.getDateOfBirth() == null || this.getTitle() == null) {
			return false;
		}
		return true;
	}

	@OnEvent(value = "submit", component = "registrationform")
	public Object onRegistrationFormSubmit() {

		if (checkFields()) {
			passenger.setFirstName(getFirstName());
			passenger.setLastName(getLastname());
			passenger.setDateOfBirth(getDateOfBirth());
			passenger.setUsername(getUsername());
			passenger.setPassword(getPassword());
			passenger.setTitle(getFirstName());

			try {
				registerPassenger.registerPassenger(passenger);

			} catch (PassengerAlreadyExistsException e) {
				// TODO Auto-generated catch block
				this
						.setMessage("Passenger with provided username and password already exists!");
				return null;
			}

			this.setMessage("Profile has been updated.");
			return null;
		} else {
			this.setMessage("Validation error. Check fields");
			return null;
		}

	}

}
