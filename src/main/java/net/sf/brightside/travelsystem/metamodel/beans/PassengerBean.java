package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import net.sf.brightside.travelsystem.core.beans.BaseBean;
import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;

import org.apache.tapestry5.ioc.annotations.Scope;

@Entity
@Scope("perthread")
public class PassengerBean extends BaseBean implements Passenger, Serializable,
		Identifiable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String title;
	private String password;
	private String username;

	public PassengerBean() {

	}

	@Transient
	public String getFormatedDateOfBirth() {
		DateFormat d = DateFormat.getDateInstance(DateFormat.FULL, Locale.UK);
		return d.format(dateOfBirth).toString();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private List<Reservation> reservations;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger", targetEntity = ReservationBean.class)
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Temporal(javax.persistence.TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
