package net.sf.brightside.travelsystem.service.hibernate;

import java.util.List;

import org.hibernate.Session;

import org.springframework.transaction.annotation.Transactional;

import net.sf.brightside.travelsystem.core.command.CommandException;
import net.sf.brightside.travelsystem.core.persistence.GenericDAO;

import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.GetAllPassengers;

@SuppressWarnings("unchecked")
public class GetAllPassengersImpl implements
		GetAllPassengers<List<Passenger>, Session> {

	private GenericDAO<Session> dao;

	@Override
	@Transactional
	public List<Passenger> execute() throws CommandException {

		return dao.get(Passenger.class);

	}

	@Override
	public GenericDAO getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

	@Override
	public void setDao(GenericDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;

	}

}
