package net.sf.brightside.travelsystem.tapestry.pages.administration;

import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.City;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;
import net.sf.brightside.travelsystem.tapestry.pages.Login;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.context.ApplicationContext;

public class CityPage {
	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;

	private City city;

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

	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@SuppressWarnings("unchecked")
	public List<City> getCities() {
		return persistenceManager.get(City.class);
	}

	@OnEvent(component = "cityform", value = "submit")
	public Object onSubmitForm() {

		City a = (City) context.getBean(City.class.getName());

		a.setName(getCityName());

		admins.addCity(a);

		return null;

	}

	@SuppressWarnings("unchecked")
	@OnEvent(component = "deletecity")
	public Object onDeleteLink(Long id) {

		Object object = persistenceManager.get(
				net.sf.brightside.travelsystem.metamodel.City.class, id);

		persistenceManager.delete(object);
		return null;

	}
}
