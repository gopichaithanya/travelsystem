package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import net.sf.brightside.travelsystem.core.beans.BaseBean;
import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.Airport;
import net.sf.brightside.travelsystem.metamodel.City;

@Entity
public class CityBean extends BaseBean implements City, Serializable,
		Identifiable {

	private static final long serialVersionUID = 1L;

	private List<Airport> airports;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "city", targetEntity = AirportBean.class)
	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}

}
