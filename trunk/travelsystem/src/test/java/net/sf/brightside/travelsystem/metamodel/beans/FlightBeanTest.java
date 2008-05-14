package net.sf.brightside.travelsystem.metamodel.beans;

import java.util.Date;
import org.easymock.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Reservation;

public class FlightBeanTest {

	private Flight flight;

	@BeforeMethod
	public void setUp() {
		flight = new FlightBean();

	}

	@Test
	public void testDate() {

		Date d = new Date();

		flight.setDate(d);

		Assert.assertEquals(d, flight.getDate());

	}

	@Test
	public void testReservationAssociation() {

		Reservation rb = EasyMock.createStrictMock(Reservation.class);
	   
		Assert.assertFalse(flight.getReservations().contains(rb));
		flight.getReservations().add(rb);
		
		Assert.assertTrue(flight.getReservations().contains(rb));
	
	}
	
	
}
