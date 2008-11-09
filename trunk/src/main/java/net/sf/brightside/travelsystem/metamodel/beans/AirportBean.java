package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.sf.brightside.travelsystem.core.beans.BaseBean;
import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.Airport;
import net.sf.brightside.travelsystem.metamodel.City;
import net.sf.brightside.travelsystem.metamodel.Flight;

@Entity
public class AirportBean extends BaseBean implements Airport, Serializable,
		Identifiable {
	private static final long serialVersionUID = 1L;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	private String code;
	private List<Flight> arrivalAirportFlights;
	private List<Flight> departureAirportFlights;
	private City city;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "arrivalAirport", targetEntity = FlightBean.class)
	public List<Flight> getArrivalAirportFlights() {
		return arrivalAirportFlights;
	}

	public void setArrivalAirportFlights(List<Flight> arrivalAirportFlights) {
		this.arrivalAirportFlights = arrivalAirportFlights;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "departureAirport", targetEntity = FlightBean.class)
	public List<Flight> getDepartureAirportFlights() {
		return departureAirportFlights;
	}

	public void setDepartureAirportFlights(List<Flight> departureAirportFlights) {
		this.departureAirportFlights = departureAirportFlights;
	}

	@ManyToOne(targetEntity = CityBean.class)
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName() + ", " + this.getCode() + ", "
				+ this.getCity().getName();
	}

}
