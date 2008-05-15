package net.sf.brightside.travelsystem.service;

import net.sf.brightside.travelsystem.core.command.Command;
import net.sf.brightside.travelsystem.core.persistence.GenericDAO;
import net.sf.brightside.travelsystem.metamodel.Passenger;

public interface RegisterPassenger<ReturnType, ManagerType> extends Command<ReturnType, ManagerType>{
		
		
	public Passenger getPassenger();
	
	public void setPassenger(Passenger passenger);

}
