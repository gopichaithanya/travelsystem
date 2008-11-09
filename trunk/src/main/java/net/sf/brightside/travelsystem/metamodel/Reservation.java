package net.sf.brightside.travelsystem.metamodel;

import java.util.Date;

import net.sf.brightside.travelsystem.core.Base;

public interface Reservation extends Base {

	public Flight getFlight();

	public void setFlight(Flight flight);

	public Meal getMeal();

	public void setMeal(Meal meal);

	public Passenger getPassenger();

	public void setPassenger(Passenger passenger);

	public Boolean getReserved();

	public void setReserved(Boolean reserved);

	public Date getReservationTime();

	public void setReservationTime(Date reservationTime);

	public Seat getSeat();

	public void setSeat(Seat seat);

	public CabinClass getCabinClass();

	public void setCabinClass(CabinClass cabinClass);

	public Double getPrice();

	public void setPrice(Double price);

}
