package net.sf.brightside.travelsystem.metamodel.beans;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import net.sf.brightside.travelsystem.metamodel.Airport;

import org.easymock.EasyMock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CityBeanTest {

	private CityBean city;

	@BeforeMethod
	public void setUp() throws Exception {
		city = new CityBean();
		city.setAirports(new ArrayList<Airport>());

	}

	@Test
	public void testGetName() {
		String name = "New York";
		city.setName(name);
		assertEquals(city.getName(), name);
	}

	@Test
	public void testGetAirports() {
		Airport a = EasyMock.createStrictMock(Airport.class);

		city.getAirports().add(a);
		assertTrue(city.getAirports().contains(a));
	}

}
