package net.sf.brightside.travelsystem.metamodel.beans.spring.integration;

import static junit.framework.Assert.assertNotNull;
import net.sf.brightside.travelsystem.core.spring.AbstractSpringTest;
import net.sf.brightside.travelsystem.metamodel.Airline;
import net.sf.brightside.travelsystem.metamodel.Airport;
import net.sf.brightside.travelsystem.metamodel.CabinClass;
import net.sf.brightside.travelsystem.metamodel.City;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Plain;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.metamodel.Seat;

import org.testng.annotations.Test;

public class GetMetamodelBeanFromSpringTest extends AbstractSpringTest {

	@Test
	public void getAirline() {

		assertNotNull(context.getBean(Airline.class.getName()));

	}

	@Test
	public void getAirport() {
		assertNotNull(context.getBean(Airport.class.getName()));
	}

	@Test
	public void getCabinClass() {
		assertNotNull(context.getBean(CabinClass.class.getName()));
	}

	@Test
	public void getCity() {
		assertNotNull(context.getBean(City.class.getName()));
	}

	@Test
	public void getFlight() {
		assertNotNull(context.getBean(Flight.class.getName()));
	}

	@Test
	public void getPassenger() {
		assertNotNull(context.getBean(Passenger.class.getName()));
	}

	@Test
	public void getPlain() {
		assertNotNull(context.getBean(Plain.class.getName()));
	}

	@Test
	public void getReservation() {
		assertNotNull(context.getBean(Reservation.class.getName()));
	}

	@Test
	public void getSeat() {
		assertNotNull(context.getBean(Seat.class.getName()));
	}

}
