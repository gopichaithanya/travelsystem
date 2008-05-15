package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import javax.persistence.Id;

@Entity
@Table(name = "RESERVATIONS")
public class ReservationBean implements Reservation, Serializable, Identifiable {

	/**
	 * 
	 */
	private Long _id;
	private String _uuid = UUID.randomUUID().toString();

	private static final long serialVersionUID = 1435675432198656708L;
	
	
	
	
	private Passenger passenger;


	private Flight flight;

	@Column(name = "RESERVATION_DATE")
	private Date date;

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	@Override
	@ManyToOne(targetEntity = FlightBean.class)
	@JoinColumn(name = "FLIGHT_ID_FK")
	public Flight getFlight() {
		// TODO Auto-generated method stub
		return flight;
	}

	@Override
	@ManyToOne(targetEntity = PassengerBean.class)
	@JoinColumn(name = "PASSENGER_ID_FK")
	public Passenger getPassenger() {
		// TODO Auto-generated method stub
		return passenger;
	}

	@Override
	public void setDate(Date date) {
		// TODO Auto-generated method stub

		this.date = date;
	}

	@Override
	public void setFlight(Flight flight) {
		// TODO Auto-generated method stub

		this.flight = flight;

	}

	@Override
	public void setPassenger(Passenger passenger) {
		// TODO Auto-generated method stub

		this.passenger = passenger;

	}

	
	
	@Override
	public int hashCode() {
		if (get_uuid() != null) {
			return get_uuid().hashCode();
		} else {
			return super.hashCode();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || !(o instanceof Identifiable)) {
			return false;
		}
		Identifiable other = (Identifiable) o;
		if (get_id() != null) {
			return get_id().equals(other.get_id());
		}
		if (get_uuid() == null)
			return false;
		return get_uuid().equals(other.get_uuid());
	}

	@Override
	public void set_id(Serializable id) {
		// TODO Auto-generated method stub
		
		this.set_id((Long)id);
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESERVATION_ID")
	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public String get_uuid() {
		return _uuid;
	}

	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}


}
