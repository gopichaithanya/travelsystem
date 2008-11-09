package net.sf.brightside.travelsystem.service.command.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import net.sf.brightside.travelsystem.core.command.CommandException;
import net.sf.brightside.travelsystem.core.command.SaveEntity;
import net.sf.brightside.travelsystem.metamodel.Passenger;
import net.sf.brightside.travelsystem.service.command.RegisterPassengerCommand;

public class RegisterPassengerImpl extends HibernateDaoSupport implements RegisterPassengerCommand<Boolean> {

	private Passenger passenger;
	private SaveEntity saveEntity;

	public SaveEntity getSaveEntity() {
		return saveEntity;
	}

	public void setSaveEntity(SaveEntity saveEntity) {
		this.saveEntity = saveEntity;
	}

	@Override
	@Transactional
	public Boolean execute() throws CommandException {
		// TODO Auto-generated method stub

		saveEntity.setObject(passenger);

		saveEntity.execute();

		return new Boolean(true);
	}

	@Override
	public Passenger getPassenger() {
		// TODO Auto-generated method stub
		return passenger;
	}

	@Override
	public void setPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		this.passenger = passenger;

	}

}
