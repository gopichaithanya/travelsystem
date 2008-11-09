package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import net.sf.brightside.travelsystem.core.beans.BaseBean;
import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Plain;
import net.sf.brightside.travelsystem.metamodel.Seat;

@Entity
public class PlainBean extends BaseBean implements Plain, Serializable,
		Identifiable {

	private static final long serialVersionUID = 1L;

	private String type;
	private String name;
	private List<Flight> flights;
	private List<Seat> seats;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "plain", targetEntity = SeatBean.class)
	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "plain", targetEntity = FlightBean.class)
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName() + ", " + type + ", plain no. " + this.get_id();
	}

}
