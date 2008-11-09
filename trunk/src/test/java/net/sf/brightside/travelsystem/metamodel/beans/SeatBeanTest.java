package net.sf.brightside.travelsystem.metamodel.beans;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import net.sf.brightside.travelsystem.metamodel.Plain;
import net.sf.brightside.travelsystem.metamodel.Reservation;

import org.easymock.EasyMock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeatBeanTest {

	private SeatBean seat;

	@BeforeMethod
	public void setUp() throws Exception {
		seat = new SeatBean();
		seat.setReservations(new ArrayList<Reservation>());
	}

	@Test
	public void testGetNumber() {
		Integer i = 333;
		seat.setNumber(i);

		assertEquals(seat.getNumber(), i);
	}

	@Test
	public void testGetPlain() {

		Plain p = EasyMock.createStrictMock(Plain.class);

		seat.setPlain(p);

		assertEquals(seat.getPlain(), p);

	}

	@Test
	public void testGetReservations() {
		Reservation r = EasyMock.createStrictMock(Reservation.class);
		seat.getReservations().add(r);
		assertTrue(seat.getReservations().contains(r));
	}

}
