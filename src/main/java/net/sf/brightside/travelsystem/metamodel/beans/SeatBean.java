package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.sf.brightside.travelsystem.core.beans.BaseBean;
import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.Plain;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.metamodel.Seat;

import org.hibernate.annotations.Cascade;

@Entity
public class SeatBean extends BaseBean implements Seat, Serializable,
		Identifiable {
	private static final long serialVersionUID = 1L;

	private Integer number;
	private Plain plain;
	private List<Reservation> reservations;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@ManyToOne(targetEntity = PlainBean.class)
	public Plain getPlain() {
		return plain;
	}

	public void setPlain(Plain plain) {
		this.plain = plain;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "seat", targetEntity = ReservationBean.class)
	@Cascade( { org.hibernate.annotations.CascadeType.ALL,
			org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "seat number: " + this.getNumber().toString();
	}

}
