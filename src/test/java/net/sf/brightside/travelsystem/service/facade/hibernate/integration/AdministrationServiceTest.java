package net.sf.brightside.travelsystem.service.facade.hibernate.integration;

import java.util.Date;

import net.sf.brightside.travelsystem.core.spring.AbstractSpringTest;
import net.sf.brightside.travelsystem.metamodel.Airline;
import net.sf.brightside.travelsystem.metamodel.Airport;
import net.sf.brightside.travelsystem.metamodel.CabinClass;
import net.sf.brightside.travelsystem.metamodel.City;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Meal;
import net.sf.brightside.travelsystem.metamodel.Plain;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.metamodel.Seat;
import net.sf.brightside.travelsystem.metamodel.beans.AirlineBean;
import net.sf.brightside.travelsystem.metamodel.beans.AirportBean;
import net.sf.brightside.travelsystem.metamodel.beans.CabinClassBean;
import net.sf.brightside.travelsystem.metamodel.beans.CityBean;
import net.sf.brightside.travelsystem.metamodel.beans.FlightBean;
import net.sf.brightside.travelsystem.metamodel.beans.MealBean;
import net.sf.brightside.travelsystem.metamodel.beans.PlainBean;
import net.sf.brightside.travelsystem.metamodel.beans.ReservationBean;
import net.sf.brightside.travelsystem.metamodel.beans.SeatBean;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdministrationServiceTest extends AbstractSpringTest {

	private AdministrationService underTest;

	@BeforeMethod
	public void setUp() throws Exception {

		underTest = (AdministrationService) context
				.getBean(AdministrationService.class.getName());
	}

	@Test
	public void testAddAirport() {
		Airport ap1 = new AirportBean();
		ap1.setName("Adelaide International Airport");
		underTest.addAirport(ap1);
	}

	@Test
	public void testAddArline() {
		Airline a1 = new AirlineBean();
		a1.setName("Air France");
		underTest.addArline(a1);
	}

	@Test
	public void testAddCabinClass() {
		CabinClass cc1 = new CabinClassBean();
		cc1.setCabinClass("First class");
		underTest.addCabinClass(cc1);
	}

	@Test
	public void testAddCity() {
		City c1 = new CityBean();
		c1.setName("Adelaide");
		underTest.addCity(c1);
	}

	@Test
	public void testCreateFlight() {
		Airline a1 = new AirlineBean();
		a1.setName("Air France");
		Airline a2 = new AirlineBean();
		a2.setName("Lufthansa");
		getPersistenceManager().save(a1);
		getPersistenceManager().save(a2);

		City c1 = new CityBean();
		c1.setName("Adelaide");
		getPersistenceManager().save(c1);

		Airport ap1 = new AirportBean();
		ap1.setName("Adelaide International Airport");
		ap1.setCity(c1);
		ap1.setCode("ADL");
		getPersistenceManager().save(ap1);

		City c2 = new CityBean();
		c2.setName("Melbourne");
		getPersistenceManager().save(c2);

		Airport ap2 = new AirportBean();
		ap2.setName("Melbourne International Airport");
		ap2.setCity(c2);
		ap2.setCode("MEL");
		getPersistenceManager().save(ap2);

		CabinClass cc1 = new CabinClassBean();
		cc1.setCabinClass("First class");
		getPersistenceManager().save(cc1);

		CabinClass cc2 = new CabinClassBean();
		cc2.setCabinClass("Economic");
		getPersistenceManager().save(cc2);

		Meal m1 = new MealBean();
		m1.setName("Bacon and aggs");
		getPersistenceManager().save(m1);

		Plain p1 = new PlainBean();
		p1.setName("Jumbo Jet");
		getPersistenceManager().save(p1);

		Seat s1 = new SeatBean();

		s1.setNumber(324);
		s1.setPlain(p1);

		getPersistenceManager().save(s1);

		Flight flight = new FlightBean();

		flight.setDepartureTime(new Date());
		flight.setArrivalTime(new Date());

		flight.setAirline(a1);
		flight.setDepartureAirport(ap1);
		flight.setArrivalAirport(ap2);
		flight.setPlain(p1);
		flight.setNumber(12345);
		underTest.createFlight(flight);
	}

	@Test
	public void testCreateReservation() {
		Airline a1 = new AirlineBean();
		a1.setName("Air France");
		Airline a2 = new AirlineBean();
		a2.setName("Lufthansa");
		getPersistenceManager().save(a1);
		getPersistenceManager().save(a2);

		City c1 = new CityBean();
		c1.setName("Adelaide");
		getPersistenceManager().save(c1);

		Airport ap1 = new AirportBean();
		ap1.setName("Adelaide International Airport");
		ap1.setCity(c1);
		ap1.setCode("ADL");
		getPersistenceManager().save(ap1);

		City c2 = new CityBean();
		c2.setName("Melbourne");
		getPersistenceManager().save(c2);

		Airport ap2 = new AirportBean();
		ap2.setName("Melbourne International Airport");
		ap2.setCity(c2);
		ap2.setCode("MEL");
		getPersistenceManager().save(ap2);

		CabinClass cc1 = new CabinClassBean();
		cc1.setCabinClass("First class");
		getPersistenceManager().save(cc1);

		CabinClass cc2 = new CabinClassBean();
		cc2.setCabinClass("Economic");
		getPersistenceManager().save(cc2);

		Meal m1 = new MealBean();
		m1.setName("Bacon and aggs");
		getPersistenceManager().save(m1);

		Plain p1 = new PlainBean();
		p1.setName("Jumbo Jet");
		getPersistenceManager().save(p1);

		Seat s1 = new SeatBean();

		s1.setNumber(324);
		s1.setPlain(p1);

		getPersistenceManager().save(s1);

		Flight flight = new FlightBean();

		flight.setDepartureTime(new Date());
		flight.setArrivalTime(new Date());

		flight.setAirline(a1);
		flight.setDepartureAirport(ap1);
		flight.setArrivalAirport(ap2);
		flight.setPlain(p1);
		flight.setNumber(12345);
		underTest.createFlight(flight);

		Reservation r = new ReservationBean();
		r.setCabinClass(cc2);
		r.setReserved(false);
		r.setFlight(flight);
		r.setSeat(null);
		r.setPrice(100.99);
		r.setReservationTime(null);
		r.setMeal(null);

		underTest.createReservation(r);

	}

	@Test
	public void testAddMeal() {
		Meal m1 = new MealBean();
		m1.setName("Bacon and aggs");
		underTest.addMeal(m1);
	}

	@Test
	public void testAddPlain() {
		Plain p1 = new PlainBean();
		p1.setName("Jumbo Jet");
		underTest.addPlain(p1);
	}

	@Test
	public void testAddSeat() {
		Seat s1 = new SeatBean();
		Plain p1 = new PlainBean();
		p1.setName("Jumbo Jet");
		getPersistenceManager().save(p1);

		s1.setNumber(324);
		s1.setPlain(p1);

		underTest.addSeat(s1);

	}

}
