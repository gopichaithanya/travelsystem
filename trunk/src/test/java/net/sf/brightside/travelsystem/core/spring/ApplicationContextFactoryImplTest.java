package net.sf.brightside.travelsystem.core.spring;

import static org.testng.AssertJUnit.*;

import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplicationContextFactoryImplTest {

	ApplicationContextFactory acf;

	@BeforeMethod
	public void setUp() {
		acf = new ApplicationContextFactoryImpl();

	}

	@Test
	public void testLocations() {

		assertEquals(5, acf.getLocations().length);

	}

	@Test
	public void testSingletonInstanceNotNull() {
		ApplicationContext ac;

		ac = acf.getApplicationContextInstance();

		assertNotNull(ac);

	}

	@Test
	public void testReservationBean() {

		ApplicationContext ac;

		ac = acf.getApplicationContextInstance();

		Reservation res = (Reservation) ac.getBean(Reservation.class.getName());

		assertNotNull(res);

	}

	@Test
	public void testPassengerBean() {
		ApplicationContext ac;

		ac = acf.getApplicationContextInstance();

		Passenger p = (Passenger) ac.getBean(Passenger.class.getName());

		assertNotNull(p);

	}

	@Test
	public void testFlightBean() {
		ApplicationContext ac;

		ac = acf.getApplicationContextInstance();

		Flight f = (Flight) ac.getBean(Flight.class.getName());

		assertNotNull(f);

	}
}
