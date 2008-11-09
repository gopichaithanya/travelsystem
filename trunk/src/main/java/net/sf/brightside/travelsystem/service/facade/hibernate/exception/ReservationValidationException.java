package net.sf.brightside.travelsystem.service.facade.hibernate.exception;

@SuppressWarnings("serial")
public class ReservationValidationException extends RuntimeException {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Error validating reservation data.";
	}

}
