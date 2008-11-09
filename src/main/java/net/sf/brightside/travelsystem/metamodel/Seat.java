package net.sf.brightside.travelsystem.metamodel;

import java.util.List;

import net.sf.brightside.travelsystem.core.Base;

public interface Seat extends Base {

	public Integer getNumber();

	public void setNumber(Integer number);

	public Plain getPlain();

	public void setPlain(Plain plain);

	public List<Reservation> getReservations();

	public void setReservations(List<Reservation> reservations);
}
