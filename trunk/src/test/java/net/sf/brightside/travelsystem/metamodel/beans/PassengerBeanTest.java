package net.sf.brightside.travelsystem.metamodel.beans;

import net.sf.brightside.travelsystem.metamodel.Reservation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.easymock.EasyMock;

public class PassengerBeanTest {

	private PassengerBean pb;

	@BeforeMethod
	public void setUp() {

		pb = new PassengerBean();
	}

	@Test
	public void testFirstName() {

		String name = "Johnny";

		Assert.assertNull(pb.getFirstName());
		pb.setFirstName(name);

		Assert.assertEquals(pb.getFirstName(), name);

	}

	@Test
	public void testLastName() {

		String lastname = "boy";
		Assert.assertNull(pb.getLastName());
		pb.setLastName(lastname);
		Assert.assertEquals(pb.getLastName(), lastname);

	}

	@Test
	public void testFirstNameSetNull() {

		String name = "Johnny";

		Assert.assertNull(pb.getFirstName());
		pb.setFirstName(name);

		Assert.assertEquals(pb.getFirstName(), name);

		pb.setFirstName(null);

		Assert.assertNull(pb.getFirstName());
	}

	@Test
	public void testLastNameSetNull() {
		String lastname = "boy";
		Assert.assertNull(pb.getLastName());
		pb.setLastName(lastname);
		Assert.assertEquals(pb.getLastName(), lastname);
		pb.setLastName(null);
		Assert.assertNull(pb.getLastName());

	}

	@Test
	public void testReservationsNotNull() {
		Assert.assertNotNull(pb.getReservations());
	}

	@Test
	public void testReservationAsociations() {

		Reservation rb = EasyMock.createStrictMock(Reservation.class);
		
		Assert.assertFalse(pb.getReservations().contains(rb));
		pb.getReservations().add(rb);

		Assert.assertTrue(pb.getReservations().contains(rb));

	}

}
