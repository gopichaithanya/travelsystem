package net.sf.brightside.travelsystem.service.facade.hibernate.exception;

public class CanNotAddSeatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1171343473380270275L;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Plain can not have two seats with same number.";
	}

}
