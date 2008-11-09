package net.sf.brightside.travelsystem.metamodel.beans;

import static org.testng.Assert.assertEquals;

import java.util.Date;

import net.sf.brightside.travelsystem.metamodel.CabinClass;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Meal;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Seat;

import org.easymock.EasyMock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReservationBeanTest {

	private ReservationBean r;

	@BeforeMethod
	public void setUp() {

		r = new ReservationBean();

	}

	@Test
	public void testDate() {

	}

	@Test
	public void testFlightAssociation() {

		Flight f = EasyMock.createStrictMock(Flight.class);
		r.setFlight(f);
		assertEquals(r.getFlight(), f);
	}

	@Test
	public void testPassenger() {

		Passenger p = EasyMock.createStrictMock(Passenger.class);

		r.setPassenger(p);

		assertEquals(r.getPassenger(), p);

	}

	@Test
	public void testGetFlight() {
		Flight f = EasyMock.createStrictMock(Flight.class);
		r.setFlight(f);
		assertEquals(r.getFlight(), f);
	}

	@Test
	public void testGetMeal() {
		Meal f = EasyMock.createStrictMock(Meal.class);
		r.setMeal(f);
		assertEquals(r.getMeal(), f);
	}

	@Test
	public void testReserved() {
		Boolean b = true;
		r.setReserved(b);
		assertEquals(r.getReserved(), b);
	}

	@Test
	public void testReservationTime() {
		Date d = new Date();
		r.setReservationTime(d);
		assertEquals(r.getReservationTime(), d);
	}

	@Test
	public void testSeat() {
		Seat s = EasyMock.createStrictMock(Seat.class);
		r.setSeat(s);
		assertEquals(r.getSeat(), s);
	}

	@Test
	public void testCabinClass() {
		CabinClass s = EasyMock.createStrictMock(CabinClass.class);
		r.setCabinClass(s);
		assertEquals(r.getCabinClass(), s);
	}

	@Test
	public void testPrice() {
		Double s = 200.0;
		r.setPrice(s);
		assertEquals(r.getPrice(), s);
	}
}
