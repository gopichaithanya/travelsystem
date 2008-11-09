package net.sf.brightside.travelsystem.service.facade.hibernate.exception;

@SuppressWarnings("serial")
public class PaymentErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5934753046231921385L;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Unable to execute money transaction.";
	}

}
