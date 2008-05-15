package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.*;

@Entity
@Table(name = "PASSENGER")
public class PassengerBean implements Passenger, Serializable,Identifiable {

	/**
	 * 
	 */

	private Long _id;
	private String _uuid = UUID.randomUUID().toString();

	private static final long serialVersionUID = 1435675432198656708L;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	private List<Reservation> reservations = new ArrayList<Reservation>();

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	@Override
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger", targetEntity = ReservationBean.class)
	public List<Reservation> getReservations() {
		// TODO Auto-generated method stub
		return reservations;
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PASSENGER_ID")
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
