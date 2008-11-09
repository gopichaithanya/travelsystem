package net.sf.brightside.travelsystem.core.command.hibernate;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import net.sf.brightside.travelsystem.core.command.CommandException;
import net.sf.brightside.travelsystem.core.command.SaveEntity;

public class SaveEntityImpl extends HibernateDaoSupport implements
		SaveEntity {

	private Object object;

	@Override
	public Object getObject() {
		return object;
	}

	@Override
	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	@Transactional
	public Boolean execute() throws CommandException {
		// TODO Auto-generated method stub

		Session session = this.getSessionFactory().getCurrentSession();

		session.saveOrUpdate(object);

		return new Boolean(true);
	}

}
