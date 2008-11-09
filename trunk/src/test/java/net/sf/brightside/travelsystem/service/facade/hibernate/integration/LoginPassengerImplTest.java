package net.sf.brightside.travelsystem.service.facade.hibernate.integration;

import net.sf.brightside.travelsystem.core.spring.AbstractSpringTest;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.facade.LoginPassenger;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPassengerImplTest extends AbstractSpringTest {

	LoginPassenger underTest;

	@BeforeMethod
	public void setUp() {
		underTest = (LoginPassenger) context.getBean(LoginPassenger.class
				.getName());
	}

	@Test
	public void loginTest() {

		Passenger p = (Passenger) context.getBean(Passenger.class.getName());
		p.setUsername("paja");
		p.setPassword("patak");

		this.getPersistenceManager().save(p);

		Passenger login = underTest.login(p);

		Assert.assertNotNull(login);

	}
}
