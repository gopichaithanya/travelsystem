package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import net.sf.brightside.travelsystem.core.beans.BaseBean;
import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.Airline;
import net.sf.brightside.travelsystem.metamodel.Flight;

@Entity
public class AirlineBean extends BaseBean implements Airline, Serializable,
		Identifiable {
	private static final long serialVersionUID = 1L;

	private String name;
	private List<Flight> flights;

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "airline", targetEntity = FlightBean.class)
	public List<Flight> getFlights() {
		return this.flights;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}

}
