package net.sf.brightside.travelsystem.metamodel;

import java.util.List;

public interface Passenger {

	public String getFirstName();

	public void setFirstName(String name);

	public String getLastName();

	public void setLastName(String lastName);

	public List<Reservation> getReservations();

}
