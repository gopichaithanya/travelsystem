package net.sf.brightside.travelsystem.metamodel.beans;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import net.sf.brightside.travelsystem.metamodel.Flight;

import org.easymock.EasyMock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AirlineBeanTest {
	private AirlineBean airline;

	@BeforeMethod
	public void setUp() throws Exception {
		airline = new AirlineBean();
		airline.setFlights(new ArrayList<Flight>());

	}

	@Test
	public void testGetFlights() {
		Flight f = EasyMock.createStrictMock(Flight.class);

		airline.getFlights().add(f);
		assertTrue(airline.getFlights().contains(f));
	}

	@Test
	public void testGetName() {
		String n = "Air France";
		airline.setName(n);
		assertEquals(n, airline.getName());
	}

}
