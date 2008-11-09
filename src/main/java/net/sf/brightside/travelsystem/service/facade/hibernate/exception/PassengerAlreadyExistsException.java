package net.sf.brightside.travelsystem.service.facade.hibernate.exception;

public class PassengerAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Passenger with username and password provided already exists.";
	}

}
