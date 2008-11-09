package net.sf.brightside.travelsystem.metamodel;

import java.util.List;

import net.sf.brightside.travelsystem.core.Base;

public interface Plain extends Base {

	public List<Flight> getFlights();

	public List<Seat> getSeats();

	public String getName();

	public void setName(String name);

	public String getType();

	public void setType(String type);

}
