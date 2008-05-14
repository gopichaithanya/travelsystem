package net.sf.brightside.travelsystem.core.spring;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.brightside.travelsystem.core.command.Command;
import net.sf.brightside.travelsystem.core.command.CommandException;
import net.sf.brightside.travelsystem.core.hibernate.HibernateGenericDAOImpl;
import net.sf.brightside.travelsystem.core.persistence.GenericDAO;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.metamodel.beans.FlightBean;
import net.sf.brightside.travelsystem.metamodel.beans.PassengerBean;
import net.sf.brightside.travelsystem.metamodel.beans.ReservationBean;
import net.sf.brightside.travelsystem.service.GetAllPassengers;
import net.sf.brightside.travelsystem.service.RegisterPassenger;

import net.sf.brightside.travelsystem.service.hibernate.RegisterPassengerImpl;

import net.sf.brightside.travelsystem.service.hibernate.GetAllPassengersImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IntTest {

	ApplicationContextFactoryImpl factory;
	ApplicationContext context;

	@BeforeMethod
	public void setUp() {

		factory = new ApplicationContextFactoryImpl();

		context = factory.getApplicationContextInstance();

	}

	// this is not a real unit test of course is just something I've been
	// playing with

	@SuppressWarnings("unchecked")
	@Test
	public void hittingDatabaseTest() {

		RegisterPassenger<Passenger, Session> rp = (RegisterPassenger) context
				.getBean(RegisterPassenger.class.getName());

		Passenger pb = (Passenger) context.getBean(Passenger.class.getName());

		pb.setFirstName("Marko");
		pb.setLastName("Markovic");

		rp.setPassenger(pb);

		try {
			rp.execute();
		} catch (CommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Flight fl = (Flight) context.getBean(Flight.class.getName());
		 * fl.setDate(new Date());
		 * 
		 * 
		 * Reservation res = (Reservation) context.getBean(Reservation.class
		 * .getName()); res.setDate(new Date()); res.setFlight(fl);
		 * res.setPassenger(pb);
		 * 
		 */

		GetAllPassengers<List<Passenger>, Session> ga = (GetAllPassengers) context
				.getBean(GetAllPassengers.class.getName());

		List<Passenger> list = null;
		try {
			list = ga.execute();
		} catch (CommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Passenger passenger : list) {
			System.out.println(passenger.getFirstName() + " "
					+ passenger.getLastName());
		}

	}

}
