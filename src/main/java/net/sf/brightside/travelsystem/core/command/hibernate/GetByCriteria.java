package net.sf.brightside.travelsystem.core.command.hibernate;

import org.hibernate.criterion.DetachedCriteria;

import net.sf.brightside.travelsystem.core.command.Command;

public interface GetByCriteria<ReturnType> extends Command<ReturnType> {
	
	public DetachedCriteria getDetachedCriteria ();
	
	public void setDetachedCriteria(DetachedCriteria detachedCriteria);

}
