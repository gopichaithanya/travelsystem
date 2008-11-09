package net.sf.brightside.travelsystem.service.facade.hibernate;

import java.util.ArrayList;
import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;
import net.sf.brightside.travelsystem.metamodel.Airline;
import net.sf.brightside.travelsystem.metamodel.Airport;
import net.sf.brightside.travelsystem.metamodel.CabinClass;
import net.sf.brightside.travelsystem.metamodel.City;
import net.sf.brightside.travelsystem.metamodel.Flight;
import net.sf.brightside.travelsystem.metamodel.Meal;
import net.sf.brightside.travelsystem.metamodel.Plain;
import net.sf.brightside.travelsystem.metamodel.Reservation;
import net.sf.brightside.travelsystem.metamodel.Seat;
import net.sf.brightside.travelsystem.service.facade.AdministrationService;
import net.sf.brightside.travelsystem.service.facade.hibernate.exception.CanNotAddSeatException;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class AdministrationServiceImpl implements AdministrationService {

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

	@Override
	@Transactional
	public void addAirport(Airport airport) {
		// TODO Auto-generated method stub

		persistenceManager.saveOrUpdate(airport);

	}

	@Override
	@Transactional
	public void addArline(Airline airline) {
		// TODO Auto-generated method stub
		persistenceManager.saveOrUpdate(airline);
	}

	@Override
	@Transactional
	public void addCabinClass(CabinClass cabinClass) {
		// TODO Auto-generated method stub
		persistenceManager.saveOrUpdate(cabinClass);
	}

	@Override
	@Transactional
	public void addCity(City city) {
		// TODO Auto-generated method stub
		persistenceManager.saveOrUpdate(city);
	}

	@Override
	@Transactional
	public void createFlight(Flight flight) {
		// TODO Auto-generated method stub
		persistenceManager.saveOrUpdate(flight);
	}

	@Override
	@Transactional
	public void createReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		persistenceManager.saveOrUpdate(reservation);
	}

	@Override
	@Transactional
	public void addMeal(Meal meal) {
		// TODO Auto-generated method stub
		persistenceManager.saveOrUpdate(meal);
	}

	@Override
	@Transactional
	public void addPlain(Plain plain) {
		// TODO Auto-generated method stub
		persistenceManager.saveOrUpdate(plain);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void addSeat(Seat seat) throws CanNotAddSeatException {
		// TODO Auto-generated method stub

		List<Seat> seats = getAllSeatsForPlain(seat.getPlain());

		for (Seat seat2 : seats) {
			if (seat2.getNumber().equals(seat.getNumber())) {
				throw new CanNotAddSeatException();
			}
		}

		persistenceManager.saveOrUpdate(seat);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Seat> getAllSeatsForPlain(Plain plain) {
		DetachedCriteria dcriteria = DetachedCriteria.forClass(Seat.class);
		dcriteria.add(Restrictions.eq("plain", plain));
		List<Seat> seats = persistenceManager.executeDetachedCriteria(
				Seat.class, dcriteria);
		return seats;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Seat> getAvailableSeats(Flight flight) {
		// TODO Auto-generated method stub
		Plain plain = flight.getPlain();

		DetachedCriteria dcriteria1 = DetachedCriteria.forClass(Seat.class);
		dcriteria1.add(Restrictions.eq("plain", plain));

		List<Seat> seats = persistenceManager.executeDetachedCriteria(
				Seat.class, dcriteria1);

		List<Reservation> listRes = returnReservationsForFlight(flight);

		List<Seat> availableSeats = new ArrayList<Seat>();
		if (listRes.size() == 0) {
			return seats;
		}

		List<Seat> reservedSeats = new ArrayList<Seat>();

		for (Reservation res : listRes) {
			reservedSeats.add(res.getSeat());
		}

		for (Seat seat : seats) {
			if (reservedSeats.contains(seat)) {
				continue;
			}
			availableSeats.add(seat);
		}

		return availableSeats;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Reservation> returnReservationsForFlight(Flight flight) {
		DetachedCriteria dcriteria = DetachedCriteria
				.forClass(Reservation.class);
		dcriteria.add(Restrictions.eq("flight", flight));

		List<Reservation> listRes = persistenceManager.executeDetachedCriteria(
				Reservation.class, dcriteria);
		return listRes;
	}

}
