package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import net.sf.brightside.travelsystem.core.beans.BaseBean;
import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.CabinClass;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Meal;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.metamodel.Seat;

@Entity
public class ReservationBean extends BaseBean implements Reservation,
		Serializable, Identifiable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Passenger passenger;
	private Meal meal;
	private Date reservationTime;
	private Boolean reserved;
	private Flight flight;
	private Seat seat;
	private CabinClass cabinClass;
	private Double price;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToOne(targetEntity = MealBean.class)
	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	@ManyToOne(targetEntity = CabinClassBean.class)
	public CabinClass getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(CabinClass cabinClass) {
		this.cabinClass = cabinClass;
	}

	@ManyToOne(targetEntity = PassengerBean.class)
	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@Transient
	public String getFormatedReservationTime() {
		DateFormat d = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.MEDIUM, Locale.UK);
		return d.format(reservationTime).toString();
	}

	@ManyToOne(targetEntity = FlightBean.class)
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Boolean getReserved() {
		return reserved;
	}

	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}

	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	public Date getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}

	@ManyToOne(targetEntity = SeatBean.class)
	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}
