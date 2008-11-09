package net.sf.brightside.travelsystem.tapestry.components;

import net.sf.brightside.travelsystem.metamodel.Passenger;

import org.apache.tapestry5.annotations.ApplicationState;

public class NavigBar {
	@ApplicationState
	private Passenger passenger;

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	private boolean passengerExists;

	public boolean isPassengerExists() {
		return passengerExists;
	}

	public void setPassengerExists(boolean passengerExists) {
		this.passengerExists = passengerExists;
	}

}
