package net.sf.brightside.travelsystem.service.facade.hibernate.integration;

import net.sf.brightside.travelsystem.core.spring.AbstractSpringTest;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.ViewReservations;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ViewReservationsImplTest extends AbstractSpringTest {

	ViewReservations underTest;

	@BeforeMethod
	public void setUp() {
		underTest = (ViewReservations) context.getBean(ViewReservations.class
				.getName());
	}

	@Test
	public void returnAllReservations() {

		Passenger p = (Passenger) context.getBean(Passenger.class.getName());

		p.setFirstName("Nikola");
		p.setLastName("Nikolic");

		getPersistenceManager().save(p);

		underTest.returnAllReservations(p);

	}

}
