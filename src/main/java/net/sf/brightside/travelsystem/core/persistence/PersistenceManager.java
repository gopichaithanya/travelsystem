package net.sf.brightside.travelsystem.core.persistence;

import java.io.Serializable;
import java.util.List;

public interface PersistenceManager<ManagerType> {

	public ManagerType getManager();

	public <T> List<T> get(Class<T> searchType);

	public <T> T get(Class<T> type, Serializable id);

	public <T> List<T> get(Class<T> searchType, int firstReslult, int lastResult);

	public <T> List<T> get(T example);

	public <T> List<T> get(T example, int firstResult, int maxResults);

	public <T> List<T> get(Class<T> searchForType, T example);

	public <T> List<T> get(Class<T> searchForType, T example, int firstResult,
			int maxResults);

	public void save(Object object);

	public void saveOrUpdate(Object object);

	public void delete(Object object);

	public void delete(Serializable id);

	public void deleteAll(Class<Object> typeToDelete);

	public <T> List<T> executeDetachedCriteria(Class<T> type, Object dcriteria);

	public <T> List<T> executeQuery(Class<T> type, String jpql, List<?> param);

	public void flush();

	public void clear();

}
