package net.sf.brightside.travelsystem.service.hibernate;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import net.sf.brightside.travelsystem.core.persistence.GenericDAO;
import net.sf.brightside.travelsystem.core.spring.ApplicationContextFactoryImpl;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.RegisterPassenger;

@SuppressWarnings("unchecked")
public class RegisterPassengerImpl implements RegisterPassenger<Boolean,Session> {

	
	private Passenger passenger;
	
	private GenericDAO<Session> dao;
	
	
	public RegisterPassengerImpl(Passenger passenger) {
		super();
		this.passenger = passenger;
	}

	public RegisterPassengerImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override	
	public Boolean execute() {

		// TODO Auto-generated method stub
		
		dao.save(passenger);
		
		
      return true;
		
	}

	@Override
	public Passenger getPassenger() {
		// TODO Auto-generated method stub
		return this.passenger;
	}

	@Override
	public void setPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		
		this.passenger = passenger;
		
	}

	@Override
	public GenericDAO<Session> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

	@Override
	public void setDao(GenericDAO<Session> dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
		
	}


}
