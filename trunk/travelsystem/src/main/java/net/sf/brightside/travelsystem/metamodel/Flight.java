package net.sf.brightside.travelsystem.metamodel;

import java.util.Date;
import java.util.List;

public interface Flight {
	
	public Date getDate();

	public void setDate(Date date);
	
	public List<Reservation> getReservations();

}
