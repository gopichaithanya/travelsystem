package net.sf.brightside.travelsystem.metamodel.beans;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Seat;

import org.easymock.EasyMock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlainBeanTest {

	private PlainBean plain;

	@BeforeMethod
	public void setUp() throws Exception {
		plain = new PlainBean();
		plain.setFlights(new ArrayList<Flight>());
		plain.setSeats(new ArrayList<Seat>());
	}

	@Test
	public void testGetSeats() {
		Seat s = EasyMock.createStrictMock(Seat.class);
		plain.getSeats().add(s);
		assertTrue(plain.getSeats().contains(s));

	}

	@Test
	public void testGetFlights() {
		Flight s = EasyMock.createStrictMock(Flight.class);
		plain.getFlights().add(s);
		assertTrue(plain.getFlights().contains(s));
	}

	@Test
	public void testGetName() {
		String s = "Boing 747";

		plain.setName(s);
		assertEquals(plain.getName(), s);
	}

	@Test
	public void testGetType() {
		String s = "type";

		plain.setType(s);
		assertEquals(plain.getType(), s);
	}

}
