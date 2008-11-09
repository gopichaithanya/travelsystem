package net.sf.brightside.travelsystem.tapestry.pages.administration;

import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Plain;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;
import net.sf.brightside.travelsystem.tapestry.pages.Login;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.context.ApplicationContext;

public class PlainPage {
	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;

	private Plain plain;

	public Plain getPlain() {
		return plain;
	}

	public void setPlain(Plain plain) {
		this.plain = plain;
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

	private String plainName;

	private String typeOfPlain;

	public String getTypeOfPlain() {
		return typeOfPlain;
	}

	public void setTypeOfPlain(String typeOfPlain) {
		this.typeOfPlain = typeOfPlain;
	}

	public String getPlainName() {
		return plainName;
	}

	public void setPlainName(String plainName) {
		this.plainName = plainName;
	}

	@SuppressWarnings("unchecked")
	public List<Plain> getPlains() {
		return persistenceManager.get(Plain.class);
	}

	@OnEvent(component = "Plainform", value = "submit")
	public Object onSubmitForm() {

		Plain a = (Plain) context.getBean(Plain.class.getName());

		a.setName(getPlainName());
		a.setType(getTypeOfPlain());
		admins.addPlain(a);

		return null;

	}

	@SuppressWarnings("unchecked")
	@OnEvent(component = "deleteplain")
	public Object onDeleteLink(Long id) {

		Object object = persistenceManager.get(Plain.class, id);

		persistenceManager.delete(object);
		return null;

	}
}
