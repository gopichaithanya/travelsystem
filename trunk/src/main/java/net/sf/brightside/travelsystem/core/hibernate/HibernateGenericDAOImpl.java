package net.sf.brightside.travelsystem.core.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import net.sf.brightside.travelsystem.core.persistence.GenericDAO;

public class HibernateGenericDAOImpl extends HibernateDaoSupport implements
		GenericDAO<Session> {

	@Override
	@Transactional
	public void clear() {
		// TODO Auto-generated method stub

		this.getManager().flush();

	}

	@Override
	@Transactional
	public void delete(Object object) {
		// TODO Auto-generated method stub

		this.getManager().delete(object);

	}

	@Override
	@Transactional
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		Object toBeDeleted = get(id);
		delete(toBeDeleted);
	}

	@Override
	@Transactional
	public void deleteAll(Class<Object> typeToDelete) {
		// TODO Auto-generated method stub

		Session session = getManager();
		session.delete("from " + typeToDelete.getName());

	}

	@Override
	@Transactional
	public void flush() {
		// TODO Auto-generated method stub
		this.getManager().flush();

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> List<T> get(Class<T> searchType) {
		// TODO Auto-generated method stub

		Criteria criteria = this.getManager().createCriteria(searchType);

		return criteria.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> T get(Class<T> type, Serializable id) {
		// TODO Auto-generated method stub

		Criteria criteria = this.getManager().createCriteria(type);
		criteria.add(Restrictions.idEq(id));
		return (T) criteria.uniqueResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> List<T> get(Class<T> searchType, int firstReslult, int lastResult) {
		// TODO Auto-generated method stub

		Criteria criteria = this.getManager().createCriteria(searchType);
		criteria.setMaxResults(lastResult);
		criteria.setFirstResult(firstReslult);

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> List<T> get(T example) {
		// TODO Auto-generated method stub
		return get((Class<T>) example.getClass(), example);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> List<T> get(T example, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return get((Class<T>) example.getClass(), example, firstResult,
				maxResults);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Session getManager() {
		// TODO Auto-generated method stub
		return this.getSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void save(Object object) {
		// TODO Auto-generated method stub

		this.getManager().saveOrUpdate(object);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> List<T> get(Class<T> searchForType, T example) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getManager().createCriteria(searchForType);
		criteria.add(Example.create(example));
		return criteria.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> List<T> get(Class<T> searchForType, T example, int firstResult,
			int maxResults) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getManager().createCriteria(searchForType);
		criteria.add(Example.create(example));
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);
		return criteria.list();
	}

}
