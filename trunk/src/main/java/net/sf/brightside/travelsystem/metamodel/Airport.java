package net.sf.brightside.travelsystem.metamodel;

import java.util.List;

import net.sf.brightside.travelsystem.core.Base;

public interface Airport extends Base {
	public String getName();

	public void setName(String name);

	public City getCity();

	public void setCity(City city);

	public String getCode();

	public void setCode(String code);

	public List<Flight> getArrivalAirportFlights();

	public List<Flight> getDepartureAirportFlights();
}
