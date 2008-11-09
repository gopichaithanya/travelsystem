package net.sf.brightside.travelsystem.tapestry.pages.administration;

import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;
import net.sf.brightside.travelsystem.tapestry.pages.Login;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.context.ApplicationContext;

public class AirlinePage {
	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;

	private net.sf.brightside.travelsystem.metamodel.Airline airline;

	public net.sf.brightside.travelsystem.metamodel.Airline getAirline() {
		return airline;
	}

	public void setAirline(
			net.sf.brightside.travelsystem.metamodel.Airline airline) {
		this.airline = airline;
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

	private String airlineName;

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	@SuppressWarnings("unchecked")
	public List<AirlinePage> getAirlines() {
		return persistenceManager
				.get(net.sf.brightside.travelsystem.metamodel.Airline.class);
	}

	@OnEvent(component = "airlineform", value = "submit")
	public Object onSubmitForm() {

		net.sf.brightside.travelsystem.metamodel.Airline a = (net.sf.brightside.travelsystem.metamodel.Airline) context
				.getBean(net.sf.brightside.travelsystem.metamodel.Airline.class
						.getName());

		a.setName(getAirlineName());

		admins.addArline(a);

		return null;

	}

	@SuppressWarnings("unchecked")
	@OnEvent(component = "deleteairline")
	public Object onDeleteLink(Long id) {

		Object object = persistenceManager.get(
				net.sf.brightside.travelsystem.metamodel.Airline.class, id);

		persistenceManager.delete(object);
		return null;

	}

}
