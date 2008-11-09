package net.sf.brightside.travelsystem.metamodel;

import java.util.Date;
import java.util.List;

import net.sf.brightside.travelsystem.core.Base;

public interface Passenger extends Base {

	public String getFormatedDateOfBirth();

	public String getPassword();

	public void setPassword(String password);

	public String getUsername();

	public void setUsername(String username);

	public List<Reservation> getReservations();

	public void setReservations(List<Reservation> reservations);

	public Date getDateOfBirth();

	public void setDateOfBirth(Date dateOfBirth);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getTitle();

	public void setTitle(String title);

}
