package net.sf.brightside.travelsystem.tapestry.util;

import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;

import org.apache.tapestry5.ValueEncoder;

public class BeanEncoder<Bean> implements ValueEncoder<Bean> {

	@SuppressWarnings("unchecked")
	private PersistenceManager pm;
	private Class<Bean> clazz;

	@SuppressWarnings("unchecked")
	public BeanEncoder(PersistenceManager pm, Class<Bean> clazz) {
		super();
		this.pm = pm;
		this.clazz = clazz;
	}

	@Override
	public String toClient(Bean arg0) {
		// TODO Auto-generated method stub

		return ((Identifiable) arg0).get_id().toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bean toValue(String arg0) {
		// TODO Auto-generated method stub

		Long id = Long.parseLong(arg0);

		return (Bean) pm.get(clazz, id);
	}
}
