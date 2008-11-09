package net.sf.brightside.travelsystem.metamodel.beans;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import net.sf.brightside.travelsystem.metamodel.Reservation;

import org.easymock.EasyMock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MealBeanTest {

	private MealBean meal;

	@BeforeMethod
	public void setUp() throws Exception {
		meal = new MealBean();
		meal.setReservations(new ArrayList<Reservation>());
	}

	@Test
	public void testGetName() {
		String n = "bacon";
		meal.setName(n);
		assertEquals(n, meal.getName());
	}

	@Test
	public void testGetReservations() {
		Reservation r = EasyMock.createStrictMock(Reservation.class);
		meal.getReservations().add(r);
		assertTrue(meal.getReservations().contains(r));
	}

}
