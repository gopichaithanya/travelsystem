package net.sf.brightside.travelsystem.metamodel.beans;

import static org.testng.Assert.assertEquals;
import net.sf.brightside.travelsystem.metamodel.CabinClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CabinClassBeanTest {
	private CabinClass cabinClass;

	@BeforeMethod
	public void setUp() throws Exception {
		cabinClass = new CabinClassBean();
	}

	@Test
	public void testGetCabinClass() {
		String s = "first class";
		cabinClass.setCabinClass(s);
		assertEquals(cabinClass.getCabinClass(), s);
	}

}
