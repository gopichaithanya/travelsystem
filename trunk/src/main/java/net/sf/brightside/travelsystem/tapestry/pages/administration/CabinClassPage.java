package net.sf.brightside.travelsystem.tapestry.pages.administration;

import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.CabinClass;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;
import net.sf.brightside.travelsystem.tapestry.pages.Login;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.context.ApplicationContext;

public class CabinClassPage {
	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;

	private CabinClass cabinClass;

	public CabinClass getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(CabinClass cabinClass) {
		this.cabinClass = cabinClass;
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

	private String cabinClassName;

	public String getCabinClassName() {
		return cabinClassName;
	}

	public void setCabinClassName(String cabinClassName) {
		this.cabinClassName = cabinClassName;
	}

	@SuppressWarnings("unchecked")
	public List<CabinClass> getCabinClasses() {
		return persistenceManager.get(CabinClass.class);
	}

	@OnEvent(component = "cabinclassform", value = "submit")
	public Object onSubmitForm() {

		CabinClass a = (CabinClass) context.getBean(CabinClass.class.getName());

		a.setCabinClass(getCabinClassName());

		admins.addCabinClass(a);

		return null;

	}

	@SuppressWarnings("unchecked")
	@OnEvent(component = "deletecabinclass")
	public Object onDeleteLink(Long id) {

		Object object = persistenceManager.get(
				net.sf.brightside.travelsystem.metamodel.CabinClass.class, id);

		persistenceManager.delete(object);
		return null;

	}

}
