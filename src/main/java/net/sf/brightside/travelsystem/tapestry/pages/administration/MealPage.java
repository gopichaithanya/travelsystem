package net.sf.brightside.travelsystem.tapestry.pages.administration;

import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Meal;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;
import net.sf.brightside.travelsystem.tapestry.pages.Login;
import net.sf.brightside.travelsystem.tapestry.providers.SpringBean;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.context.ApplicationContext;

public class MealPage {
	@ApplicationState
	private Passenger passenger;
	private boolean passengerExists;

	private Meal meal;

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
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

	private String mealName;

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	@SuppressWarnings("unchecked")
	public List<Meal> getMeals() {
		return persistenceManager.get(Meal.class);
	}

	@OnEvent(component = "mealform", value = "submit")
	public Object onSubmitForm() {

		Meal a = (Meal) context.getBean(Meal.class.getName());

		a.setName(getMealName());

		admins.addMeal(a);

		return null;

	}

	@SuppressWarnings("unchecked")
	@OnEvent(component = "deletemeal")
	public Object onDeleteLink(Long id) {

		Object object = persistenceManager.get(Meal.class, id);

		persistenceManager.delete(object);
		return null;

	}

}
