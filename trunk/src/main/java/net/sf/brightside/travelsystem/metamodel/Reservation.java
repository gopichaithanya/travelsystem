package net.sf.brightside.travelsystem.metamodel;

import java.util.Date;

public interface Reservation {

	public Date getDate();

	public void setDate(Date date);

	public Flight getFlight();

	public void setFlight(Flight flight);

	public Passenger getPassenger();

	public void setPassenger(Passenger passenger);

}
