package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import javax.persistence.Id;

@Entity
@Table(name = "FLIGHTS")
public class FlightBean implements Flight, Serializable,Identifiable {

	/**
	 * 
	 */
	private Long _id;
	private String _uuid = UUID.randomUUID().toString();

	private static final long serialVersionUID = 1435675432198656708L;

	private Date date;

	private List<Reservation> reservations = new ArrayList<Reservation>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FLIGHT_ID")
	public Long get_id() {
		return _id;
	}

	@Column(name = "FLIGHT_DATE")
	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	@Override
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "flight", targetEntity = ReservationBean.class)
	public List<Reservation> getReservations() {
		// TODO Auto-generated method stub
		return this.reservations;
	}

	@Override
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.date = date;

	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
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


}
