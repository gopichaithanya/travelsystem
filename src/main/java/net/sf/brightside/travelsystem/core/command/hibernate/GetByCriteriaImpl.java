package net.sf.brightside.travelsystem.core.command.hibernate;

import net.sf.brightside.travelsystem.core.command.CommandException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GetByCriteriaImpl<ReturnType> extends HibernateDaoSupport
		implements GetByCriteria<ReturnType> {

	private DetachedCriteria dcriteria;

	@Override
	public DetachedCriteria getDetachedCriteria() {
		// TODO Auto-generated method stub
		return dcriteria;
	}

	@Override
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		this.dcriteria = detachedCriteria;

	}

	@SuppressWarnings("unchecked")
	@Override
	public ReturnType execute() throws CommandException {
		// TODO Auto-generated method stub

		Session session = this.getSession();

		Criteria criteria = dcriteria.getExecutableCriteria(session);

		return (ReturnType) criteria.list();
	}

}
