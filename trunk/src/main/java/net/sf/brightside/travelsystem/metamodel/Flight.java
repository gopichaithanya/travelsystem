package net.sf.brightside.travelsystem.metamodel;

import java.util.Date;
import java.util.List;

import net.sf.brightside.travelsystem.core.Base;

public interface Flight extends Base {

	public Airline getAirline();

	public void setAirline(Airline airline);

	public Airport getArrivalAirport();

	public void setArrivalAirport(Airport arrivalAirport);

	public void setArrivalTime(Date arrivalTime);

	public Date getArrivalTime();

	public Airport getDepartureAirport();

	public void setDepartureAirport(Airport departureAirport);

	public Date getDepartureTime();

	public void setDepartureTime(Date departureTime);

	public Integer getNumber();

	public void setNumber(Integer number);

	public Plain getPlain();

	public void setPlain(Plain plain);

	public List<Reservation> getReservations();

}
