package net.sf.brightside.travelsystem.service.command;

import net.sf.brightside.travelsystem.core.command.Command;
import net.sf.brightside.travelsystem.metamodel.Passenger;

public interface RegisterPassengerCommand<ReturnType> extends Command<ReturnType> {
	
	public void setPassenger(Passenger passenger);
	public Passenger getPassenger();
	

}
