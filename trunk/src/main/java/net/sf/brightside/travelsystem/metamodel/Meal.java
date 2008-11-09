package net.sf.brightside.travelsystem.metamodel;

import java.util.List;

import net.sf.brightside.travelsystem.core.Base;

public interface Meal extends Base {

	public List<Reservation> getReservations();

	public String getName();

	public void setName(String name);
}
