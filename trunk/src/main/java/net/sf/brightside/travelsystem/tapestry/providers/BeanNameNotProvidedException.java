package net.sf.brightside.travelsystem.tapestry.providers;

public class BeanNameNotProvidedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	Class clazz;

	@SuppressWarnings("unchecked")
	public BeanNameNotProvidedException(Class clazz) {
		super();
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Getting name instance of class " + clazz.getName()
				+ " failed. Provide bean name.";

	}
}
