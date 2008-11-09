package net.sf.brightside.travelsystem.service.facade.hibernate.integration;

import java.util.Date;

import net.sf.brightside.travelsystem.core.spring.AbstractSpringTest;
import net.sf.brightside.travelsystem.metamodel.Airline;
import net.sf.brightside.travelsystem.metamodel.Airport;
import net.sf.brightside.travelsystem.metamodel.CabinClass;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.service.facade.SearchFlights;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchFlightImplTest extends AbstractSpringTest {

	SearchFlights underTest;

	@BeforeMethod
	public void setUp() {
		underTest = (SearchFlights) context.getBean(SearchFlights.class
				.getName());
	}

	@Test
	public void searchFlights() {

		Reservation r = (Reservation) context.getBean(Reservation.class
				.getName());
		r.setReservationTime(new Date());
		Flight f = (Flight) context.getBean(Flight.class.getName());

		Airport aairport = (Airport) context.getBean(Airport.class.getName());
		aairport.setCode("aaa");
		this.getPersistenceManager().save(aairport);

		Airport dairport = (Airport) context.getBean(Airport.class.getName());
		dairport.setCode("€dd");

		this.getPersistenceManager().save(dairport);

		f.setDepartureTime(new Date());
		f.setDepartureAirport(dairport);
		f.setArrivalAirport(aairport);

		CabinClass c = (CabinClass) context.getBean(CabinClass.class.getName());
		c.setCabinClass("First class");
		this.getPersistenceManager().save(c);

		Airline a = (Airline) context.getBean(Airline.class.getName());
		a.setName("American Airlines");

		this.getPersistenceManager().save(a);
		f.setAirline(a);
		this.getPersistenceManager().save(f);
		r.setFlight(f);
		r.setCabinClass(c);
		r.setReserved(false);
		this.getPersistenceManager().save(r);

		underTest.searchFlights(r);

	}

}
