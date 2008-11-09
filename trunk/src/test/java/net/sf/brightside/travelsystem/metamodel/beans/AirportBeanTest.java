package net.sf.brightside.travelsystem.metamodel.beans;

import static org.testng.Assert.assertEquals;
import net.sf.brightside.travelsystem.metamodel.City;

import org.easymock.EasyMock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AirportBeanTest {

	private AirportBean airport;

	@BeforeMethod
	public void setUp() throws Exception {
		airport = new AirportBean();

	}

	@Test
	public void testGetName() {
		String name = "New York airport";
		airport.setName(name);
		assertEquals(airport.getName(), name);
	}

	@Test
	public void testGetCode() {
		String code = "asdf";
		airport.setCode(code);
		assertEquals(code, airport.getCode());
	}

	@Test
	public void testGetCity() {
		City c = EasyMock.createStrictMock(City.class);
		airport.setCity(c);
		assertEquals(c, airport.getCity());
	}

}
