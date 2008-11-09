package net.sf.brightside.travelsystem.core.command.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import net.sf.brightside.travelsystem.core.command.CommandException;
import net.sf.brightside.travelsystem.core.command.DeleteAllEntities;

public class DeleteAllEntetiesImpl<ClassType> extends HibernateDaoSupport
		implements DeleteAllEntities<Boolean, ClassType> {

	Class<ClassType> clazz;

	@Override
	public Class<ClassType> getClassType() {
		// TODO Auto-generated method stub
		return this.clazz;
	}

	@Override
	public void setClassType(Class<ClassType> clazz) {
		// TODO Auto-generated method stub
		this.clazz = clazz;

	}

	@Override
	public Boolean execute() throws CommandException {
		// TODO Auto-generated method stub

		Session session = this.getSession();

		Query query = session.createQuery("from " + clazz.getName());

		query.executeUpdate();

		return new Boolean(true);
	}

}
