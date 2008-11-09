package net.sf.brightside.travelsystem.core.command.hibernate;

import net.sf.brightside.travelsystem.core.command.CommandException;
import net.sf.brightside.travelsystem.core.command.GetAllEntities;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class GetAllEntitiesImpl<ReturnType, ClassType> extends
		HibernateDaoSupport implements GetAllEntities<ReturnType, ClassType> {

	private Class<ClassType> clazz;

	@Override
	public Class<ClassType> getClassType() {
		// TODO Auto-generated method stub
		return clazz;
	}

	@Override
	public void setClassType(Class<ClassType> clazz) {
		// TODO Auto-generated method stub
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ReturnType execute() throws CommandException {
		// TODO Auto-generated method stub

		Session session = this.getSessionFactory().getCurrentSession();

		Criteria criteria = session.createCriteria(getClassType());

		return (ReturnType) criteria.list();
	}

}
