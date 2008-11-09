package net.sf.brightside.travelsystem.tapestry.pages;

import net.sf.brightside.travelsystem.metamodel.Passenger;

import org.apache.tapestry5.annotations.ApplicationState;

public class Logout {

	@SuppressWarnings("unused")
	@ApplicationState
	private Passenger passenger;

	Object onActivate() {
		passenger = null;
		return Index.class;
	}

}
