package net.sf.brightside.travelsystem.core.hibernate;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersistenceManagerTest {

	private HibernatePersistenceManagerImpl daoImpl;

	protected Session session;

	protected Criteria criteria;

	protected Serializable id;

	protected SessionFactory sessionFactory;

	protected HibernatePersistenceManagerImpl createTestedObject() {
		return new HibernatePersistenceManagerImpl();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		daoImpl = createTestedObject();
		session = createStrictMock(Session.class);
		sessionFactory = createStrictMock(SessionFactory.class);
		daoImpl.setSessionFactory(sessionFactory);
		criteria = createStrictMock(Criteria.class);
		id = new Long(1);
	}

	/**
	 * Tests <code>get</code> method that uses object's type as a parameter.
	 */
	@Test()
	public void testGetByType() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		expect(session.createCriteria(Object.class)).andReturn(criteria);
		List queryResult = new LinkedList();
		expect(criteria.list()).andReturn(queryResult);
		replay(sessionFactory);
		replay(session);
		replay(criteria);
		assertEquals("Search for all objects should return List queryResult.", //$NON-NLS-1$
				queryResult, daoImpl.get(Object.class));
		verify(sessionFactory);
		verify(session);
		verify(criteria);
	}

	/**
	 * Tests <code>get</code> method that uses object's type as a parameter,
	 * in the case when the exception is thrown.
	 */
	@Test()
	public void testGetByTypeThrownHibernateException() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		expect(session.createCriteria(Object.class)).andReturn(criteria);
		expect(criteria.list()).andThrow(new HibernateException("Expected"));
		replay(sessionFactory);
		replay(session);
		replay(criteria);
		try {
			daoImpl.get(Object.class);
			fail("HibernateException should have been thrown.");
		} catch (HibernateException expected) {
			assertTrue("Expected exception has been thrown.", true);
		}
		verify(session);
		verify(sessionFactory);
		verify(criteria);
	}

	/**
	 * Tests <code>get</code> method that uses object's type and id as the
	 * parameters.
	 */
	@SuppressWarnings("unchecked")
	@Test()
	public void testGetByTypeID() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		expect(session.createCriteria(Object.class)).andReturn(criteria);
		List queryResult = new LinkedList();
		Object resultObject = new Object();
		queryResult.add(resultObject);
		expect(criteria.add(isA(Criterion.class))).andReturn(criteria);
		expect(criteria.setMaxResults(eq(1))).andReturn(criteria);
		expect(criteria.list()).andReturn(queryResult);
		replay(session);
		replay(sessionFactory);
		replay(criteria);

	}

	
	@SuppressWarnings("unchecked")
	@Test()
	public void testGetByTypeExample() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		expect(session.createCriteria(Object.class)).andReturn(criteria);
		List queryResult = new LinkedList();
		Object resultObject = new Object();
		queryResult.add(resultObject);
		expect(criteria.add(isA(Criterion.class))).andReturn(criteria);
		expect(criteria.list()).andReturn(queryResult);
		replay(session);
		replay(sessionFactory);
		replay(criteria);
		assertEquals("Search for all objects should return List queryResult.",
				queryResult, daoImpl.get(Object.class, new Object()));
		verify(session);
		verify(sessionFactory);
		verify(criteria);
	}

	/**
	 * Tests <code>get</code> method that uses object's type and example
	 * object as the parameters in the case when the exception is thrown.
	 */
	@SuppressWarnings("unchecked")
	@Test()
	public void testGetByTypeExampleThrownHibernateException() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		expect(session.createCriteria(Object.class)).andReturn(criteria);
		List queryResult = new LinkedList();
		Object resultObject = new Object();
		queryResult.add(resultObject);
		expect(criteria.add(isA(Criterion.class))).andReturn(criteria);
		expect(criteria.list()).andThrow(new HibernateException("Expected"));
		;
		replay(session);
		replay(sessionFactory);
		replay(criteria);
		try {
			daoImpl.get(Object.class, new Object());
			fail("HibernateException should have been thrown."); //$NON-NLS-1$
		} catch (HibernateException expected) {
			assertTrue("Expected exception has been thrown.", true); //$NON-NLS-1$
		}
		verify(session);
		verify(sessionFactory);
		verify(criteria);
	}

	/**
	 * Tests <code>save</code> method.
	 */
	@Test()
	public void testSave() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		Serializable arg = createNiceMock(Serializable.class);
		session.saveOrUpdate(arg);
		replay(session);
		replay(sessionFactory);
		daoImpl.save(arg);
		assertTrue("Saving has been executed sucessfully.", true); //$NON-NLS-1$
		verify(session);
		verify(sessionFactory);
	}

	/**
	 * Tests <code>save</code> method in the case when the exception is
	 * thrown.
	 */
	@Test()
	public void testSaveThrownHibernateException() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		Object arg = new Object();
		session.saveOrUpdate(arg);
		expectLastCall().andThrow(new HibernateException("Expected"));
		replay(session);
		replay(sessionFactory);
		try {
			daoImpl.save(arg);
			fail("HibernateException should have been thrown."); //$NON-NLS-1$
		} catch (HibernateException expected) {
			assertTrue("Expected exception has been thrown.", true); //$NON-NLS-1$
		}
		verify(sessionFactory);
		verify(session);
	}

	/**
	 * Tests <code>delete</code> method when the object that should be deleted
	 * is provided.
	 */
	@Test()
	public void testDeleteObject() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		Object arg = new Object();
		session.delete(arg);
		replay(session);
		replay(sessionFactory);
		daoImpl.delete(arg);
		assertTrue("Deletion has been executed sucessfully.", true); //$NON-NLS-1$
		verify(session);
		verify(sessionFactory);
	}

	/**
	 * Tests <code>delete</code> method when the object that should be deleted
	 * in the case when the exception is thrown.
	 */
	@Test()
	public void testdDeleteObjectThrownHibernateException() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		Object arg = new Object();
		session.delete(arg);
		expectLastCall().andThrow(new HibernateException("Expected"));
		replay(session);
		replay(sessionFactory);
		try {
			daoImpl.delete(arg);
			fail("HibernateException should have been thrown."); //$NON-NLS-1$
		} catch (HibernateException expected) {
			assertTrue("Expected exception has been thrown.", true); //$NON-NLS-1$
		}
		verify(session);
		verify(sessionFactory);
	}

	/**
	 * Tests <code>flush</code> method.
	 */
	@Test()
	public void testFlush() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		session.flush();
		replay(session);
		replay(sessionFactory);
		daoImpl.flush();
		assertTrue("Flushing has been executed sucessfully.", true); //$NON-NLS-1$
		verify(session);
		verify(sessionFactory);
	}

	/**
	 * Tests <code>flush</code> method in the case when the exception is
	 * thrown.
	 */
	@Test()
	public void testFlushThrownHibernateException() {
		expect(sessionFactory.getCurrentSession()).andReturn(session);
		session.flush();
		expectLastCall().andThrow(new HibernateException("Expected"));
		replay(session);
		replay(sessionFactory);
		try {
			daoImpl.flush();
			fail("HibernateException should have been thrown."); //$NON-NLS-1$
		} catch (HibernateException expected) {
			assertTrue("Expected exception has been thrown.", true); //$NON-NLS-1$
		}
		verify(session);
		verify(sessionFactory);
	}

}
