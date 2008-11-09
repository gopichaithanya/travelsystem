package net.sf.brightside.travelsystem.metamodel;

import java.util.List;

import net.sf.brightside.travelsystem.core.Base;

public interface City extends Base {

	public String getName();

	public void setName(String name);

	public List<Airport> getAirports();
}
