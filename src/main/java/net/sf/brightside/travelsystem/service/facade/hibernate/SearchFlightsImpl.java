package net.sf.brightside.travelsystem.service.facade.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.service.facade.SearchFlights;

public class SearchFlightsImpl implements SearchFlights {

	@SuppressWarnings("unchecked")
	private PersistenceManager persistenceManager;

	@SuppressWarnings("unchecked")
	public PersistenceManager getPersistenceManager() {
		return persistenceManager;
	}

	@SuppressWarnings("unchecked")
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> searchFlights(Reservation reservation) {
		// TODO Auto-generated method stub

		String hql = "from ReservationBean as r where r.reserved=? and r.cabinClass=?"
				+ " and r.flight.airline=? and r.flight.departureAirport=?"
				+ " and r.flight.arrivalAirport=? and extract (year from r.flight.departureTime)=? and extract (month from r.flight.departureTime)=? and extract (day from r.flight.departureTime)=?";

		Calendar c = Calendar.getInstance();
		c.setTime(reservation.getFlight().getDepartureTime());

		c.get(1);
		c.get(5);
		c.get(2);

		List param = new ArrayList();
		param.add(new Boolean(false));
		param.add(reservation.getCabinClass());
		param.add(reservation.getFlight().getAirline());
		param.add(reservation.getFlight().getDepartureAirport());
		param.add(reservation.getFlight().getArrivalAirport());
		param.add(c.get(1));
		param.add(c.get(2) + 1);
		param.add(c.get(5));
		List<Reservation> list = this.getPersistenceManager().executeQuery(
				Reservation.class, hql, param);

		return list;

	}
}
