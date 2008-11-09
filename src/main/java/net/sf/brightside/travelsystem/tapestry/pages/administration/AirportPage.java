package net.sf.brightside.travelsystem.tapestry.pages.administration;

import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Airport;
import net.sf.brightside.travelsystem.metamodel.City;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;
import net.sf.brightside.travelsystem.tapestry.pages.Login;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;
import net.sf.brightside.travelsystem.tapestry.util.BeanEncoder;
import net.sf.brightside.travelsystem.tapestry.util.BeanSelectModel;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.context.ApplicationContext;

public class AirportPage {
	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;

	private City city;

	private Airport airport;

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Object onActivate() {

		if (!passengerExists) {
			return Login.class;
		} else {
			return null;
		}
	}

	@Inject
	@SpringBean
	private AdministrationService admins;

	@Inject
	@Service("MyApplicationContext")
	private ApplicationContext context;

	@SuppressWarnings("unchecked")
	@Inject
	@SpringBean
	private PersistenceManager persistenceManager;

	private String airportName;

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	@SuppressWarnings("unchecked")
	public List<Airport> getAirports() {
		return persistenceManager.get(Airport.class);
	}

	@SuppressWarnings("unchecked")
	public SelectModel getCities() {
		List<City> airports = persistenceManager.get(City.class);

		return new BeanSelectModel<City>(airports);
	}

	public ValueEncoder<City> getCityEncoder() {
		return new BeanEncoder<City>(persistenceManager, City.class);
	}

	private String airportCode;

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	@OnEvent(component = "airportform", value = "submit")
	public Object onSubmitForm() {

		Airport a = (Airport) context.getBean(Airport.class.getName());

		a.setCity(getCity());
		a.setName(getAirportName());
		a.setCode(getAirportCode());

		admins.addAirport(a);

		return null;

	}

	@SuppressWarnings("unchecked")
	@OnEvent(component = "deleteairport")
	public Object onDeleteLink(Long id) {

		Object object = persistenceManager.get(Airport.class, id);

		persistenceManager.delete(object);
		return null;
	}

}
