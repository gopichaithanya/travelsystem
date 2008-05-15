package net.sf.brightside.travelsystem.metamodel.beans;

import java.util.Date;
import org.easymock.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;

public class ReservationBeanTest {

	private Reservation r;

	@BeforeMethod
	public void setUp() {

		r = new ReservationBean();
	}

	@Test
	public void testDate() {

		Date d = new Date();

		r.setDate(d);

		Assert.assertEquals(d, r.getDate());

	}

	@Test
	public void testFlightAssociation() {

		Flight f = EasyMock.createStrictMock(Flight.class);
		r.setFlight(f);
		Assert.assertEquals(f, r.getFlight());
	}

	@Test
	public void testPassenger() {

		Passenger p = EasyMock.createStrictMock(Passenger.class); 

		r.setPassenger(p);

		Assert.assertEquals(p, r.getPassenger());

	}

}
