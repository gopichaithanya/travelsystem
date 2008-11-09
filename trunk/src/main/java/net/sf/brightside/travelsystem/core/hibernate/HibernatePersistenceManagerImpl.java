package net.sf.brightside.travelsystem.core.hibernate;

import java.io.Serializable;
import java.util.List;

import net.sf.brightside.travelsystem.core.persistence.PersistenceManager;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePersistenceManagerImpl extends HibernateDaoSupport
		implements PersistenceManager<Session> {

	Session session = null;

	@Override
	public Session getManager() {
		// TODO Auto-generated method stub

		return this.getSessionFactory().getCurrentSession();

	}

	@Override
	@Transactional
	public void clear() {
		// TODO Auto-generated method stub

		this.getManager().flush();

	}

	@Override
	@Transactional
	public void saveOrUpdate(Object object) {
		// TODO Auto-generated method stub
		this.getManager().saveOrUpdate(object);

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
		Session session = this.getManager();

		Criteria criteria = session.createCriteria(searchType);

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> List<T> executeDetachedCriteria(Class<T> type, Object dcriteria) {
		// TODO Auto-generated method stub
		Session session = getManager();

		DetachedCriteria dc = (DetachedCriteria) dcriteria;
		Criteria executableCriteria = dc.getExecutableCriteria(session);
		return executableCriteria.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public <T> List<T> executeQuery(Class<T> type, String hql, List<?> param) {

		Query query = this.getManager().createQuery(hql);

		int index = 0;

		for (Object object : param) {

			query.setParameter(index++, object);

		}

		return query.list();

	}

}
