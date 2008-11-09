package net.sf.brightside.travelsystem.tapestry.pages;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.LoginPassenger;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 * @author Nikola
 * 
 */
public class Login {
	@ApplicationState
	private Passenger passenger;

	private boolean passengerExists;

	private String username;
	private String password;

	@Component(id = "loginform")
	private Form loginform;

	@Persist(value = "flash")
	private String message;

	@Inject
	@SpringBean
	private LoginPassenger loginPassenger;

	@Inject
	@SpringBean
	private Passenger passengerToCheck;

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

	@Inject
	private Messages messages;

	// form validation method
	// @OnEvent(component = "loginform", value = "validate")
	// void loginFormValidation() {
	//
	// loginform.recordError("message");
	//
	// }

	@SuppressWarnings("unchecked")
	@Inject
	@SpringBean
	private PersistenceManager pm;

	@OnEvent(component = "loginform", value = "submit")
	public Object onLoginFormSubmit() {

		passengerToCheck.setUsername(getUsername());
		passengerToCheck.setPassword(getPassword());

		Passenger login = loginPassenger.login(passengerToCheck);

		if (login == null) {

			this.loginform.recordError(messages.get("login-error-message"));
			// this.setMessage("Error");
			return null;
		} else {
			this.setPassenger(login);
			return Index.class;
		}

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Form getLoginform() {
		return loginform;
	}

	public void setLoginform(Form loginform) {
		this.loginform = loginform;
	}

}
