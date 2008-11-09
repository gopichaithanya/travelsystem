package net.sf.brightside.travelsystem.tapestry.pages.administration;

import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.tapestry.pages.Login;

import org.apache.tapestry5.annotations.ApplicationState;

public class AdminPage {
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
}
